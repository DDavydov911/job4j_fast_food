package ru.job4j.fast_food_domains.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false,
                    updatable = false)}
    )
    private Set<Role> roles;
}
