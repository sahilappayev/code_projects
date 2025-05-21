package org.mn.msaccount.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "org.mn.msaccount.client")
@Configuration
public class AppConfig {
}
