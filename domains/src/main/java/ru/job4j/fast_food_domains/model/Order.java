package ru.job4j.fast_food_domains.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
public class Order {
        private long id;
        private User user;
        private Set<Dish> dishes;
        private Calendar delivered;
        private Payment payment;
        private Status status;

    }
