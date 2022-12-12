package ru.job4j.fast_food_dish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.fast_food_dish.service.DishServiceImpl;
import ru.job4j.fast_food_domains.model.Dish;

import java.util.List;

@RestController
@RequestMapping("/dishservice/api")
public class DishController {

    private final DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/test")
    public String test() {
        return "Service is working";
    }

    @GetMapping("/dish")
    public List<Dish> findAll() {
        return dishService.getMenu();
    }

    @PostMapping("/dish")
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

    @GetMapping("/dish/{id}")
    public ResponseEntity<Dish> findById(@PathVariable("id") long id) {
        var dish = this.dishService.findById(id);
        if (dish.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish is not found");
        }
        return new ResponseEntity<>(dish.get(), HttpStatus.OK);
    }

    @PutMapping("/dish")
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        this.dishService.update(dish);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/dish/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Dish dish = new Dish();
        dish.setId(id);
        this.dishService.deleteDish(dish);
        return ResponseEntity.ok().build();
    }

}