package org.mn.booking.client;

import org.mn.booking.dto.response.CatFactsResponseDto;
import org.mn.booking.dto.response.CatResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cat",
        url = "${api.cat.url}")
public interface CatClient {

    @GetMapping("/fact")
    ResponseEntity<CatResponseDto> getCatFact();

    @GetMapping("/facts")
    CatFactsResponseDto getCatFacts();

}
