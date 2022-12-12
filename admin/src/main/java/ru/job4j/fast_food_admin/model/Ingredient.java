package ru.job4j.fast_food_admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Data
public class Ingredient {
    private int id;
    private String name;
    private Double price;
}
