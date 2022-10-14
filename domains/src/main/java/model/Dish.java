package model;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dishName;
    private String description;
    private Double price;
    @ElementCollection
    /**
       @ManyToMany
       @JoinTable(
            name = "dish_food",
            joinColumns = {@JoinColumn(name = "dish_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "food_id", nullable = false,
                    updatable = false)}
       )
    */
    private Map<Food, Double> ingredients;
}
