package com.example.Spring_Data.servise;

import com.example.Spring_Data.apiRepository.OrderRepository;
import com.example.Spring_Data.dto.OrderDto;
import com.example.Spring_Data.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 19.01.2023
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepository.save(order);
        log.info("Order : " + order.getId());
        orderDto.setId(order.getId());
        return orderDto;
    }

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrder(Integer id) {
        return orderRepository.getOrderById(id);
    }

    public OrderDto getOrderById(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.orElseThrow(
                () -> new EntityNotFoundException("Order not found " + id));
        return objectMapper.convertValue(order, OrderDto.class);
    }

    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
        log.info("Delete at Order : " + id);
    }
}
