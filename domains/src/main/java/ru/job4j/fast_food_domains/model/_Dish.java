package ru.job4j.fast_food_domains.model;
/*
import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "dishes")
public class _Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dishName;
    private String description;
    private Double price;
    @ManyToMany
    @JoinTable(name = "dish_ingredient",
            joinColumns = {@JoinColumn(name = "dish_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id", nullable = false,
                    updatable = false)}
    )
    private List<Ingredient> ingredients;
}
*/