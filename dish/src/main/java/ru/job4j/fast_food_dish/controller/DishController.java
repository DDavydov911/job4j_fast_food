package ru.job4j.fast_food_dish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food_dish.service.DishService;
import ru.job4j.fast_food_domains.model.Dish;

import java.util.List;

@RestController
@RequestMapping("ds/api/v1")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/test")
    public String test() {
        return "DishService is working in dish domain";
    }

    @GetMapping("/dishes")
    public List<Dish> findAll() {
        return dishService.getMenu();
    }

    @PostMapping("/dishes")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        if (dish.getDishName() == null) {
            throw new NullPointerException("Name field must not be empty");
        }
        if (dish.getDescription() == null) {
            throw new NullPointerException("Description field must not be empty");
        }
        if (dishService.findByName(dish.getDishName()).isPresent()) {
            throw new IllegalArgumentException("Such dish name already exists");
        }
        return new ResponseEntity<>(
                dishService.save(dish),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> findById(@PathVariable("id") int id) {
        var dish = this.dishService.findById(id);
        if (dish.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish is not found");
        }
        return new ResponseEntity<>(dish.get(), HttpStatus.OK);
    }

    @PutMapping("/dishes")
    public ResponseEntity<Dish> update(@RequestBody Dish dish) {
        Dish updatedDish = this.dishService.update(dish);
        return new ResponseEntity<>(updatedDish, HttpStatus.OK);
    }

    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Dish dish = new Dish();
        dish.setId(id);
        this.dishService.deleteDish(dish);
        return ResponseEntity.ok().build();
    }

}