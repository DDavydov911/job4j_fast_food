package ru.job4j.fast_food_domains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Ingredient {
    private int id;
    private String name;
    private Double price;
}