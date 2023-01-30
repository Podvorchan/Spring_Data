package com.example.Spring_Data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Podvorchan Ruslan 19.01.2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "my_store")
public class Product {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private Double cost;


}
