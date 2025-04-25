package org.mn.booking.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mn.booking.dto.request.OrderRequestDto;
import org.mn.booking.dto.response.OrderResponseDto;
import org.mn.booking.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequestDto requestDto) {
        Order order = new Order();
        return toEntity(order, requestDto);
    }

    public Order toEntity(Order order, OrderRequestDto requestDto) {
        order.setDescription(requestDto.getDescription());
        order.setName(requestDto.getName());
        return order;
    }

    public OrderResponseDto toResponseDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setName(order.getName());
        responseDto.setDescription(order.getDescription());
        responseDto.setCreatedAt(LocalDateTime.ofInstant(order.getCreatedAt().toInstant(), ZoneId.systemDefault()));
        responseDto.setUpdatedAt(LocalDateTime.ofInstant(order.getUpdatedAt().toInstant(), ZoneId.systemDefault()));
        return responseDto;
    }


}
