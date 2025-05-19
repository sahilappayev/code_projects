package org.mn.msfile.controller;

import lombok.RequiredArgsConstructor;
import org.mn.msfile.service.ImageService;
import org.simpleframework.xml.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping(value = "/{objectName}",
            produces = {MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_PNG_VALUE})
    public byte[] getImage(@PathVariable String objectName) {
        return imageService.getImage(objectName);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String uploadImage(@RequestParam MultipartFile file,
                              @RequestParam boolean isResize) {

        return imageService.upload(file, isResize);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    public String updateImage(@RequestParam String objectName,
                              @RequestParam boolean isResize,
                              @RequestParam MultipartFile file) {
        return imageService.update(file, objectName, isResize);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteImage(@RequestParam String objectName) {
        imageService.delete(objectName);
    }

}