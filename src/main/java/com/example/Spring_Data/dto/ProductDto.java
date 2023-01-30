package com.example.Spring_Data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Podvorchan Ruslan 20.01.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;

    private String name;

    private Double cost;

}
