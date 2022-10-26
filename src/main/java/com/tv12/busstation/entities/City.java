package com.tv12.busstation.entities;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "cities",
        uniqueConstraints = {@UniqueConstraint(name = "name_constraint", columnNames = "name")}
)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, columnDefinition = "BIG INT")
    private int id;

    @Column(name = "name", updatable = false, columnDefinition = "TEXT")
    private String name;
}
