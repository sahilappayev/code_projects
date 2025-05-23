package org.mn.msproduct.client.msaccount;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsAccountErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        if (Objects.nonNull(response.body())) {
            try (InputStream inputStream = response.body().asInputStream()) {

//                System.out.println("Error response: " + inputStreamToString(inputStream));

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

                return objectMapper
                        .readValue(inputStream, MsAccountException.class);
            } catch (Exception exception) {
                log.error("Error decoding failed", exception);
            }
        }
        return null;
    }



    private String inputStreamToString(InputStream inputStream) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
    }


}
