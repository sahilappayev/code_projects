package org.mn.msproduct.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.msproduct.client.msaccount.MsAccountClient;
import org.mn.msproduct.client.msaccount.UserResponseDto;
import org.mn.msproduct.dto.request.OrderRequestDto;
import org.mn.msproduct.dto.response.OrderResponseDto;
import org.mn.msproduct.entity.Order;
import org.mn.msproduct.error.EntityNotFoundException;
import org.mn.msproduct.mapper.OrderMapper;
import org.mn.msproduct.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final MsAccountClient msAccountClient;

    @Transactional
    public OrderResponseDto create(OrderRequestDto requestDto) {
        log.info("OrderService: create order started with: {}", requestDto);
        UserResponseDto user = msAccountClient.getUserById(requestDto.getUserId());
        Order order = orderMapper.toEntity(requestDto);
        order.setUserId(user.getId());

        OrderResponseDto responseDto = orderMapper
                .toResponseDto(orderRepository.save(order));

        log.info("OrderService: create order finished with: {}", responseDto);
        return responseDto;
    }

    public OrderResponseDto findById(Long id) {
        log.info("OrderService: find order by id: {}", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));

        return orderMapper.toResponseDto(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> findAll() {
        log.info("OrderService: find all orders");
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(orderMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderResponseDto update(Long id, OrderRequestDto requestDto) {
        log.info("OrderService: update order started with: {}", requestDto);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Order.class, id));

        UserResponseDto user = msAccountClient.getUserById(requestDto.getUserId());
        order.setId(user.getId());

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


    public List<OrderResponseDto> findByUserId(Long userId) {
        log.info("OrderService: find orders by user id started with: {}", userId);
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orderMapper.toResponseDtoList(orders);
    }


}
