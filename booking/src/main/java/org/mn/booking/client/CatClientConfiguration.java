package org.mn.booking.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.codec.ErrorDecoder;
//import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class CatClientConfiguration {

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new CatErrorDecoder();
//    }

//    @Bean
//    public OkHttpClient client() {
//        return new OkHttpClient();
//    }


}
