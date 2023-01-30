package com.example.Spring_Data;


import com.example.Spring_Data.dto.OrderDto;
import com.example.Spring_Data.dto.ProductDto;
import com.example.Spring_Data.servise.OrderService;
import com.example.Spring_Data.servise.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;


@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataApplication {
    private final ProductService productService;
    private final OrderService orderService;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {

        ProductDto cocaCola = new ProductDto(1, "Coca-Cola", 38.50);
        ProductDto pepsi = new ProductDto(2, "Pepsi", 40.0);
        ProductDto borgomi = new ProductDto(3, "Borgomi", 69.3);
        ProductDto redBull = new ProductDto(4, "RedBull", 59.0);
        productService.createProduct(cocaCola);
        productService.createProduct(pepsi);
        productService.createProduct(borgomi);
        productService.createProduct(redBull);

        productService.getAllProducts();
        log.info("All products {}", productService.getAllProducts());
        OrderDto full = new OrderDto(1, LocalDate.of(2023, 01, 10), 206.8, productService.getAllProducts());
        orderService.createOrder(full);
        log.info("All products in order {}", orderService.createOrder(full));

    }
}

