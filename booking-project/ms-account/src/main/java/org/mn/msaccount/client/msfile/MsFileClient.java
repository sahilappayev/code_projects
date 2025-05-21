package org.mn.msaccount.client.msfile;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "ms-auth", url = "${api.ms-file.url}",
        configuration = MsFileClientFeignConfig.class)
public interface MsFileClient {


    @PostMapping(value = "/images")
    public String uploadImage(@RequestPart MultipartFile file,
                              @RequestParam boolean isResize);

    @PutMapping(value = "/images")
    public String updateImage(@RequestParam String objectName,
                              @RequestParam boolean isResize,
                              @RequestPart MultipartFile file);

    @DeleteMapping(value = "/images")
    public void deleteImage(@RequestParam String objectName);


}
