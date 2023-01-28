package ru.job4j.fast_food_dish.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.job4j.fast_food_dish.repository.DishStore;
import ru.job4j.fast_food_domains.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DishServiceStoreImpl implements DishService {
    private final DishStore dishStore;

    public DishServiceStoreImpl(DishStore dishStore) {
        this.dishStore = dishStore;
    }

    @Override
    public Dish save(Dish dish) {
        dishStore.save(dish);
        return dish;
    }

    @Override
    public Dish update(Dish dish) {
        dishStore.update(dish);
        return dish;
    }

    @Override
    public Optional<Dish> getById(int dishId) {
        return dishStore.findById(dishId);
    }

    @Override
    public void deleteDish(Dish dish) {
        dishStore.delete(dish.getId());
    }

    @Override
    public Double getNetCost(Dish dish) {
        return null;
    }

    @Override
    public List<Dish> getMenu() {
        List<Dish> res = new ArrayList<>();
        res.addAll(dishStore.findAll());
        return res;
    }

    @Override
    public Optional<Dish> findByName(String dishName) {
        return dishStore.findAll().stream().filter(
                dish -> dishName.equals(dish.getDishName())
        ).findFirst();
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishStore.findById(id);
    }
}
