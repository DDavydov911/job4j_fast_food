package ru.job4j.fast_food_dish.service;

import ru.job4j.fast_food_domains.model.Dish;
import java.util.List;
import java.util.Optional;

public interface DishService {
      Dish save(Dish dish);

      Dish update(Dish dish);

      Optional<Dish> getById(int dishId);

      void deleteDish(Dish dish);

      Double getNetCost(Dish dish);

      List<Dish> getMenu();

      Optional<Dish> findByName(String dishName);

      Optional<Dish> findById(int id);
}
