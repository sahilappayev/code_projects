package org.mn.msaccount.client.msproduct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.InputStream;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsProductErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        if (Objects.nonNull(response.body())) {
            try (InputStream inputStream = response.body().asInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                return objectMapper
                        .readValue(inputStream, MsProductException.class);
            } catch (Exception exception) {
                log.error("Error decoding failed", exception);
            }
        }
        return null;
    }
}
