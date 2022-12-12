package ru.job4j.fast_food_admin.service;


import org.springframework.stereotype.Service;
import ru.job4j.fast_food_admin.model.Dish;
import ru.job4j.fast_food_admin.store.DishStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DishService {

    private final DishStore store;

    public DishService(DishStore store) {
        this.store = store;
    }

    public Optional<Dish> findById(int id) {
        return store.findById(id);
    }

    public List<Dish> findAll() {
        List<Dish> result = new ArrayList<>();
        result.addAll(store.findAll());
        return result;
    }

    public Optional<Dish> update(Dish dish) {
        return store.update(dish);
    }

    public void deleteDish(int id) {
        store.delete(id);
    }

    public void save(Dish dish) {
        store.save(dish);
    }
}
