package org.mn.msaccount.client.msfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.InputStream;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsFileErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        if (Objects.nonNull(response.body())) {
            try (InputStream inputStream = response.body().asInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper
                        .readValue(inputStream, MsFileException.class);
            } catch (Exception exception) {
                log.error("Error decoding failed", exception);
            }
        }
        return null;
    }
}
