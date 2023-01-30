package com.example.Spring_Data.servise;

import com.example.Spring_Data.apiRepository.ProductRepository;
import com.example.Spring_Data.dto.ProductDto;
import com.example.Spring_Data.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Podvorchan Ruslan 25.01.2023
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;


    public ProductDto createProduct(ProductDto productDto) {

        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());

        return productDto;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(Integer id) {

        return productRepository.getProductById(id);
    }


}
