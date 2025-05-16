package org.mn.booking.service;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.mn.booking.client.CatClient;
import org.mn.booking.dto.response.CatFactsResponseDto;
import org.mn.booking.dto.response.CatResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CatService {

    private final CatClient catClient;

    @Value("${api.cat.url}")
    private String apiUrl;

    public CatResponseDto getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/fact";

        ResponseEntity<CatResponseDto> response = restTemplate
                .getForEntity(url, CatResponseDto.class, Map.of("name", "sahil"));

        response.getHeaders().forEach((key, value) ->
                System.out.println("key: " + key + " value: " + value));

        System.out.println("Response status: " + response.getStatusCode());

        return response.getBody();
    }

    public CatFactsResponseDto getCatFacts() {
        return catClient.getCatFacts();
    }

}
