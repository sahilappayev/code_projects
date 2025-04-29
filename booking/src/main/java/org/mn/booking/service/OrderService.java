package org.mn.booking.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.dto.request.OrderRequestDto;
import org.mn.booking.dto.response.OrderResponseDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.Order;
import org.mn.booking.entity.User;
import org.mn.booking.error.EntityNotFoundException;
import org.mn.booking.mapper.OrderMapper;
import org.mn.booking.mapper.OrderMapperM;
import org.mn.booking.mapper.UserMapper;
import org.mn.booking.mapper.UserMapperM;
import org.mn.booking.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapperM orderMapper;
    private final UserMapperM userMapper;
    private final UserService userService;

    @Transactional
    public OrderResponseDto create(OrderRequestDto requestDto) {
        log.info("OrderService: create order started with: {}", requestDto);
        User user = userService.findById(requestDto.getUserId());
        Order order = orderMapper.toEntity(requestDto);
        order.setUser(user);

        OrderResponseDto responseDto = orderMapper
                .toResponseDto(orderRepository.save(order));
        responseDto.setUserResponseDto(userMapper.toUserResponseDto(user));

        log.info("OrderService: create order finished with: {}", responseDto);
        return responseDto;
    }

    public OrderResponseDto findById(Long id) {
        log.info("OrderService: find order by id: {}", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));


        OrderResponseDto orderResponseDto = orderMapper.toResponseDto(order);
        orderResponseDto.setUserResponseDto(userMapper.toUserResponseDto(order.getUser()));
        return orderResponseDto;
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> findAll() {
        log.info("OrderService: find all orders");
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> {
                    OrderResponseDto responseDto = orderMapper.toResponseDto(order);
                    UserResponseDto userResponseDto = userMapper.toUserResponseDto(order.getUser());
                    responseDto.setUserResponseDto(userResponseDto);
                    return responseDto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderResponseDto update(Long id, OrderRequestDto requestDto) {
        log.info("OrderService: update order started with: {}", requestDto);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));

        User user = userService.findById(requestDto.getUserId());
        order.setUser(user);

        orderMapper.toEntity(order, requestDto);

        OrderResponseDto responseDto = orderMapper
                .toResponseDto(orderRepository.save(order));

        log.info("OrderService: update order finished with: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        log.info("OrderService: delete order started with: {}", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));
        orderRepository.delete(order);
        log.info("OrderService: delete order finished with: {}", id);
    }


}
