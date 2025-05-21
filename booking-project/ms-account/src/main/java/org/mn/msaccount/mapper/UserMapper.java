package org.mn.msaccount.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mn.msaccount.annotation.constant.RoleEnum;
import org.mn.msaccount.dto.request.UserRequestDto;
import org.mn.msaccount.dto.response.UserResponseDto;
import org.mn.msaccount.entity.Role;
import org.mn.msaccount.entity.User;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {


    User toEntity(UserRequestDto userRequestDto);

    @Mapping(target = "roles", ignore = true)
    void toEntity(@MappingTarget User user, UserRequestDto userRequestDto);

    @Mapping(target = "roles", expression = "java(toRoleEnumList(user.getRoles()))")
    UserResponseDto toUserResponseDto(User user);

    default List<RoleEnum> toRoleEnumList(Set<Role> roles) {
        return roles.stream().map(Role::getName).toList();
    }

    List<UserResponseDto> toUserResponseDtoList(List<User> users);

    @AfterMapping
    default void setCurrentDate(@MappingTarget UserResponseDto userResponseDto, User user) {
        userResponseDto.setCurrentDate(LocalDateTime.now());
        userResponseDto.setRoles(user.getRoles().stream().map(Role::getName).toList());
    }


}
