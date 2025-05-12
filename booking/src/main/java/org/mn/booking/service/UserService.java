package org.mn.booking.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.annotation.constant.RoleEnum;
import org.mn.booking.config.MinioProperties;
import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.Role;
import org.mn.booking.entity.User;
import org.mn.booking.error.EntityNotFoundException;
import org.mn.booking.mapper.UserMapperM;
import org.mn.booking.repository.RoleRepository;
import org.mn.booking.repository.UserRepository;
import org.mn.booking.util.FileUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapperM userMapper;
    private final FileService fileService;
    private final FileUtil fileUtil;
    private final MinioProperties minioProperties;
    private final PdfGeneratorService pdfGeneratorService;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        log.info("UserService: create user started with: {}", userRequestDto);
        User user = userMapper.toEntity(userRequestDto);

        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        Set<Role> roles = roleRepository.findByNameIn(userRequestDto.getRoles());
        user.setRoles(roles);

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));
        log.info("UserService: create user finished with: {}", responseDto);
        return responseDto;
    }

    public UserResponseDto findUserById(Long id) {
        String sourceMessage = messageSource
                .getMessage("age.message", new Object[]{"a", "b"}, LocaleContextHolder.getLocale());

        System.err.println("sourceMessage: " + sourceMessage);

        log.info("UserService: find user by id: {}", id);
        User user = findById(id);

        return userMapper.toUserResponseDto(user);
    }


    public byte[] generatePdf(long userId) {
        User user = findById(userId);
        String html = pdfGeneratorService.parseThymeleafTemplate(user);
        return pdfGeneratorService.generatePdfFromHtml(html);
    }

    public UserResponseDto findByUsername(String username) {
        log.info("UserService: find user by username: {}", username);
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new EntityNotFoundException(User.class, username));
        return userMapper.toUserResponseDto(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        log.info("UserService: find all users");
        List<User> users = userRepository.findAll();
        return userMapper.toUserResponseDtoList(users);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllByFirstName(String firstName) {
        log.info("UserService: findAllByFirstName : {}", firstName);
//        List<User> users = userRepository.findAllByFirstNameOrderByCreatedAtDescLastNameDesc(firstName);
//        List<User> users = userRepository.findAllByFirstNameAndOrderWithNative(firstName);
        List<User> users = userRepository.findAllByFirstNameAndOrder(firstName);

        return userMapper.toUserResponseDtoList(users);
    }

    @Transactional
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        log.info("UserService: update user started with: {}", userRequestDto);
        User user = findById(id);
        userMapper.toEntity(user, userRequestDto);

        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

//        boolean allMatch = user.getRoles().stream()
//                .map(Role::getName)
//                .allMatch(role -> userRequestDto.getRoles().contains(role));
//
//        if (!allMatch) {
        Set<Role> roles = roleRepository.findByNameIn(userRequestDto.getRoles());
        user.setRoles(roles);
//        }

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));

        log.info("UserService: update user finished with: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        log.info("UserService: delete user started with: {}", id);
//        userRepository.deleteById(id);
        User user = findById(id);
        userRepository.delete(user);
        log.info("UserService: delete user finished with: {}", id);
    }

    @Transactional
    public UserResponseDto uploadImage(Long userId, MultipartFile file) {
        log.info("UserService: upload image started with: {}", userId);
        User user = findById(userId);
        String uploadedImage = fileService.uploadImage(file, minioProperties.getImageFolder(), false);
        user.setImage(uploadedImage);
        userRepository.save(user);
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    public byte[] getImage(String fileName) {
        log.info("getFile started with {}", kv("fileName", fileName));
        return fileService.getFile(fileName, minioProperties.getImageFolder());
    }


}
