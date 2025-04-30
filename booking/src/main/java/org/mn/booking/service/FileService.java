package org.mn.booking.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.messages.ErrorResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.config.MinioProperties;
import org.mn.booking.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {

    private final MinioClient minioClient;
    private final FileUtil fileUtil;
    private final MinioProperties minioProperties;

    private final String VIDEO_MEDIA_TYPE = "video";
    private final String IMAGE_MEDIA_TYPE = "image";
    private final String PDF_MEDIA_TYPE = "pdf";

    @SneakyThrows
    public byte[] getFile(String fileName, String folder) {
        String objectName = folder + fileName;
        GetObjectArgs minioRequest = GetObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .object(objectName)
                .build();
        byte[] bytes = null;
        try {
            bytes = minioClient.getObject(minioRequest).readAllBytes();
        } catch (ErrorResponseException e) {
            ErrorResponse response = e.errorResponse();
            log.error("Minio error occurred with: {}, {}, {}",
                    kv("code", response.code()),
                    kv("message", response.message()),
                    kv("objectName", response.objectName()));
        }
        return bytes;
    }

    @SneakyThrows
    public String uploadImage(MultipartFile file, String folder, boolean isResize) {
        String fileExtension = fileUtil.getFileExtensionIfAcceptable(file, IMAGE_MEDIA_TYPE);
        String fileName = fileUtil.generateUniqueName(fileExtension);
        String objectName = folder + fileName;

        // image/2025_04_30/fileName.jpg
        InputStream inputStream = file.getInputStream();

        if (isResize) {
            BufferedImage image = ImageIO.read(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(fileUtil.resizeImage(image, image.getWidth(), image.getHeight()), fileExtension, byteArrayOutputStream);
            inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }

        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .object(objectName).stream(
                        inputStream, inputStream.available(), -1)
                .contentType(file.getContentType())
                .build());
        return fileName;
    }

    @SneakyThrows
    public void deleteFile(String fileName, String folder) {
        String objectName = folder + fileName;
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(minioProperties.getBucket()).object(objectName).build());
    }

    @SneakyThrows
    public String uploadVideo(MultipartFile file, String folder) {
        String fileExtension = fileUtil.getFileExtensionIfAcceptable(file, VIDEO_MEDIA_TYPE);
        String fileName = fileUtil.generateUniqueName(fileExtension);
        String objectName = folder + fileName;
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucket()).object(objectName).stream(
                        file.getInputStream(), file.getInputStream().available(), -1)
                .contentType(file.getContentType())
                .build());
        return fileName;
    }

    @SneakyThrows
    public String uploadPdf(MultipartFile file, String folder) {
        String fileExtension = fileUtil.getFileExtensionIfAcceptable(file, PDF_MEDIA_TYPE);
        String fileName = fileUtil.generateUniqueName(fileExtension);
        String objectName = folder + fileName;
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucket()).object(objectName).stream(
                        inputStream, inputStream.available(), -1)
                .contentType(file.getContentType())
                .build());
        return fileName;
    }

    @SneakyThrows
    public String uploadInputStreamImage(InputStream file, String folder) {
        String fileName = fileUtil.generateUniqueName(fileUtil.getFileExtensionFromInputStream(file));
        String fileExtension = fileUtil.getFileExtensionIfAcceptable(fileName, IMAGE_MEDIA_TYPE);
        Path path = new File(fileName).toPath();
        String mimeType = Files.probeContentType(path);
        fileName = fileUtil.generateUniqueName(fileExtension);
        String objectName = folder + fileName;

        minioClient.putObject(PutObjectArgs.builder()
                .bucket(minioProperties.getBucket()).object(objectName).stream(
                        file, file.available(), -1)
                .contentType(mimeType)
                .build());
        return fileName;
    }

}
