package org.mn.msproduct.client.msaccount;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class MsAccountClientFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new MsAccountErrorDecoder();
    }

}
