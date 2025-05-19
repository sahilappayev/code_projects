package org.mn.msfile.service;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.msfile.config.MinioProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageService {

    private final FileService fileService;
    private final MinioProperties minioProperties;

    public String upload(MultipartFile file,
                         boolean isResize) {
        return fileService
                .uploadImage(file, minioProperties.getImageFolder(), isResize);
    }

    public String update(MultipartFile file,
                         String objectName,
                         boolean isResize) {
        String newObjectName = null;
        try {
            newObjectName = fileService
                    .uploadImage(file, minioProperties.getImageFolder(), isResize);

            fileService.deleteFile(objectName);
        } catch (Exception exception) {
            if (Objects.nonNull(newObjectName)) {
                fileService.deleteFile(newObjectName);
            }
            throw exception;
        }

        return objectName;
    }

    public void delete(String objectName) {
        fileService.deleteFile(objectName);
    }

    public byte[] getImage(String objectName) {
        return fileService.getFile(objectName);
    }


}
