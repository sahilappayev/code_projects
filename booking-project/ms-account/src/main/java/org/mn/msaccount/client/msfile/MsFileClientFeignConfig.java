package org.mn.msaccount.client.msfile;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class MsFileClientFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new MsFileErrorDecoder();
    }

}
