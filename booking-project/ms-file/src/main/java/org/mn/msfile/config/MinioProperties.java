package org.mn.msfile.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String accessKey;
    private String secretKey;
    private String url;
    private String bucket;
    private String imageFolder;
    private String videoFolder;
    private String documentFolder;

}
