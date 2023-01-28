package ru.job4j.fast_food_admin.service;


import org.springframework.stereotype.Service;
import ru.job4j.fast_food_admin.store.DishStoreLocal;
import ru.job4j.fast_food_domains.model.Dish;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DishServiceLocal implements DishService {

    private final DishStoreLocal store;

    public DishServiceLocal(DishStoreLocal store) {
        this.store = store;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return store.findById(id);
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> result = new ArrayList<>();
        result.addAll(store.findAll());
        return result;
    }

    @Override
    public Optional<Dish> update(Dish dish) {
        return Optional.of(store.update(dish));
    }

    @Override
    public boolean deleteDish(int id) {
        return store.delete(id);
    }

    @Override
    public Optional<Dish> save(Dish dish) {
        return Optional.of(store.save(dish));
    }

    @PreDestroy
    @Override
    public void close() throws Exception {
    }
}
