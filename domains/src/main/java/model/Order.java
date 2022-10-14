package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dish> dishes;
    private Calendar created;
    private Calendar delivered;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;
    @OneToOne
    private Payment payment;
}