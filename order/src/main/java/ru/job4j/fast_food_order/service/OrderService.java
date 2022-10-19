package ru.job4j.fast_food_order.service;

import model.Order;
import model.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    Order save(Order order);

    boolean update(Order order);

    Status checkStatus(long orderId);

    boolean delete(Order order);

    List<Order> findAll();

    Optional<Order> findById(long id);
}
