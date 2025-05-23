package org.mn.msproduct.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mn.msproduct.dto.request.OrderRequestDto;
import org.mn.msproduct.dto.response.OrderResponseDto;
import org.mn.msproduct.entity.Order;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    Order toEntity(OrderRequestDto requestDto);

    void toEntity(@MappingTarget Order entity, OrderRequestDto requestDto);

    OrderResponseDto toResponseDto(Order order);

    List<OrderResponseDto> toResponseDtoList(List<Order> orders);

}
