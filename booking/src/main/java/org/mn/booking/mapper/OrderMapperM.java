package org.mn.booking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mn.booking.dto.request.OrderRequestDto;
import org.mn.booking.dto.response.OrderResponseDto;
import org.mn.booking.entity.Order;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapperM {

    Order toEntity(OrderRequestDto requestDto);

    void toEntity(@MappingTarget Order entity, OrderRequestDto requestDto);

    OrderResponseDto toResponseDto(Order order);

}
