package com.example.Spring_Data.controller;

import com.example.Spring_Data.model.Order;
import com.example.Spring_Data.servise.OrderService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Podvorchan Ruslan 20.01.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;


    @GetMapping(value = "{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }


    @GetMapping(value = "/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping(value = "{id}")
    public void deleteOrderById(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }

}
