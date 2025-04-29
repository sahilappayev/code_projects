package org.mn.booking.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapperM {


    User toEntity(UserRequestDto userRequestDto);

    void toEntity(@MappingTarget User user, UserRequestDto userRequestDto);

    @Mapping(target = "orderResponseDtoList", source = "orders")
    UserResponseDto toUserResponseDto(User user);

    @Named("toUserResponseDtoIgnoreOrders")
    @Mapping(target = "orderResponseDtoList", ignore = true)
    UserResponseDto toUserResponseDtoIgnoreOrders(User user);

    @IterableMapping(qualifiedByName = "toUserResponseDtoIgnoreOrders")
    List<UserResponseDto> toUserResponseDtoList(List<User> users);

    @AfterMapping
    default void setCurrentDate(@MappingTarget UserResponseDto userResponseDto) {
        userResponseDto.setCurrentDate(LocalDateTime.now());
    }


}
