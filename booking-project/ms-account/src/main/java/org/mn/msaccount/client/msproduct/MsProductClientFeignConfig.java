package org.mn.msaccount.client.msproduct;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class MsProductClientFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new MsProductErrorDecoder();
    }

}
