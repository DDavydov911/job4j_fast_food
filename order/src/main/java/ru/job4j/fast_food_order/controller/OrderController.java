package ru.job4j.fast_food_order.controller;

import model.Order;
import model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food_order.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        if (order.getDishes() == null) {
            throw new NullPointerException("Dishes must not be empty");
        }
        return new ResponseEntity<>(service.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable("id") int id) {
        var order = service.findById(id);
        if (order.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not found");
        }
        return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Order order) {
        this.service.update(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Order order = new Order();
        order.setId(id);
        this.service.delete(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<Status> getStatus(@PathVariable("id") long id) {
        Optional<Order> order = service.findById(id);
        if (order.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not found");
        }
        return new ResponseEntity<>(order.get().getStatus(), HttpStatus.OK);
    }
}
