package ru.job4j.fast_food_domains.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Role {
    int id;
    String role;
}
