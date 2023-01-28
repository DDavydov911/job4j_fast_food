package ru.job4j.fast_food_domains.model;
/*
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class _Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;
    @ManyToMany
    @JoinTable(
            name = "dish_ingredient",
            joinColumns = {@JoinColumn(name = "ingredient_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private Set<_Dish> dishes;//циклическая зависимость
}

 */