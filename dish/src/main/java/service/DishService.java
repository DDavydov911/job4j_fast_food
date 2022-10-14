package service;

import model.Dish;
import java.util.List;

public interface DishService {
      void addDish(Dish dish);

      void editDish(Dish dish);

      void getDish(int dishId);

      void deleteDish(Dish dish);

      Double getNetCost(Dish dish);

      List<Dish> getMenu();
}
