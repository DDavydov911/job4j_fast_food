package ru.job4j.fast_food_admin.service;

import ru.job4j.fast_food_domains.model.Dish;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;

public interface DishService {
    Optional<Dish> findById(int id);
    List<Dish> findAll();
    Optional<Dish> update(Dish dish);
    boolean deleteDish(int id);
    Optional<Dish> save(Dish dish);

    @PreDestroy
    void close() throws Exception;
}
