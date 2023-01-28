package ru.job4j.fast_food_domains.model;
/*
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class _Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<_Dish> dishes;
    private Calendar created;
    private Calendar delivered;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private _Courier courier;
    @OneToOne
    private Payment payment;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}


 */