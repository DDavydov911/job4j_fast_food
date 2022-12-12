package ru.job4j.fast_food_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fast_food_admin.model.Dish;
import ru.job4j.fast_food_admin.service.DishService;

@Controller
@RequestMapping("/api/v1/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Service is working";
    }


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dishes";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Dish dish, Model model) {
        var updatedDish = dishService.update(dish).get();
        model.addAttribute("dish", updatedDish);
        return "redirect:/api/v1/dishes/" + updatedDish.getId();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        Dish dish = this.dishService.findById(id).get();
        model.addAttribute("dish", dish);
        return "dish";
    }

    @GetMapping("/formUpdate/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("dish", dishService.findById(id).get());
        return "update2Dish";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        this.dishService.deleteDish(id);
        return "redirect:/api/v1/dishes";
    }

    @GetMapping("/addForm")
    public String getAddForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addDish(@ModelAttribute Dish dish, Model model) {
        dishService.save(dish);
        return "redirect:/api/v1/dishes";
    }
}

