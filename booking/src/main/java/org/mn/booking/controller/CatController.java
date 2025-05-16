package org.mn.booking.controller;

import lombok.RequiredArgsConstructor;
import org.mn.booking.dto.response.CatFactsResponseDto;
import org.mn.booking.dto.response.CatResponseDto;
import org.mn.booking.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cats")
public class CatController {

    private final CatService catService;

    @GetMapping("/fact")
    public ResponseEntity<CatResponseDto> getCatFact() {
        return ResponseEntity.ok(catService.getCatFact());
    }

    @GetMapping("/facts")
    public ResponseEntity<CatFactsResponseDto> getCatFacts() {
        return ResponseEntity.ok(catService.getCatFacts());
    }


}
