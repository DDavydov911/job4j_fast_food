package ru.job4j.fast_food_dish.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.job4j.fast_food_domains.model.Dish;
import ru.job4j.fast_food_domains.model.Ingredient;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Primary
public class DishStore {

    private final AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, Dish> dishes = new HashMap<>();

    public DishStore() {
        Ingredient i1 = new Ingredient(1, "Potato", 5.0);
        Ingredient i2 = new Ingredient(2, "Meet", 15.0);
        Ingredient i3 = new Ingredient(3, "Fish", 20.0);
        Dish dish1 = new Dish(id.incrementAndGet(), "name1",
                "description1", 100.0, List.of(i1, i2));
        Dish dish2 = new Dish(id.incrementAndGet(), "name2",
                "description2", 200.0, List.of(i1, i3));
        Dish dish3 = new Dish(id.incrementAndGet(), "name3",
                "description3", 300.0, List.of(i2));
        dishes.put(dish1.getId(), dish1);
        dishes.put(dish2.getId(), dish2);
        dishes.put(dish3.getId(), dish3);
    }

    public Optional<Dish> findById(int id) {
        return Optional.of(dishes.get(id));
    }

    public Collection<Dish> findAll() {
        return dishes.values();
    }

    public Optional<Dish> update(Dish dish) {
        Dish dishStored = dishes.get(dish.getId());
        dish.setIngredients(dishStored.getIngredients());
        dishes.put(dish.getId(), dish);
        return Optional.of(dish);
    }

    public void delete(int id) {
        dishes.remove(id);
    }

    public void save(Dish dish) {
        dish.setId(id.incrementAndGet());
        dishes.put(dish.getId(), dish);
    }
}
