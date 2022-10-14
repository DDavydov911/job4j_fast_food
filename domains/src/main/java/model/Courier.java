package model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    @OneToMany(mappedBy = "courier")
    private Collection<Order> orders;
}
