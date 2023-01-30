package com.example.Spring_Data.apiRepository;

import com.example.Spring_Data.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Podvorchan Ruslan 19.01.2023
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    Order getOrderById(Integer id);

}
