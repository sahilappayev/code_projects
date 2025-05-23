package org.mn.msproduct.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "org.mn.msproduct.client")
@Configuration
public class AppConfig {


}
