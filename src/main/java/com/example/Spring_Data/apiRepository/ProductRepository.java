package com.example.Spring_Data.apiRepository;

import com.example.Spring_Data.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 19.01.2023
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product getProductById(Integer id);

}
