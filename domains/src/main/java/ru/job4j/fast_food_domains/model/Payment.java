package ru.job4j.fast_food_domains.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
@RequiredArgsConstructor
@Setter
@Getter
public class Payment {
    private long id;
    private User user;
    private Order order;
    private Calendar created;
}
