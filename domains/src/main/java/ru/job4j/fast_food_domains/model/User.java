package ru.job4j.fast_food_domains.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;
@RequiredArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private String login;
    private String password;
    private Set<Order> orders;
    private Set<Role> roles;
}
