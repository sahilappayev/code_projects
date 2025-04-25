package org.mn.booking.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mn.booking.dto.request.OrderRequestDto;
import org.mn.booking.dto.response.OrderResponseDto;
import org.mn.booking.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.create(requestDto);
    }

    @PutMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id,
                                        @RequestBody OrderRequestDto requestDto) {
        return orderService.update(id, requestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }

}
