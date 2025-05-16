package org.mn.booking.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.mn.booking.dto.response.ExceptionResponse;
import org.springframework.stereotype.Component;

public class CatErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        if (response.body() != null) {

            try (InputStream inputStream = response.body().asInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();

                return objectMapper
                        .readValue(inputStream, Exception.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return null;
    }


}
