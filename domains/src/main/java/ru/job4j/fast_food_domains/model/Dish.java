package ru.job4j.fast_food_domains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Dish {
    private int id;
    private String dishName;
    private String description;
    private Double price;
    private List<Ingredient> ingredients = new ArrayList<>();
}

