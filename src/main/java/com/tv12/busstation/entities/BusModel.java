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
        name = "bus_models",
        uniqueConstraints = {@UniqueConstraint(name = "name_constraint", columnNames = "name")}
)
public class BusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, columnDefinition = "BIG INT")
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "seats_number", nullable = false, columnDefinition = "INT")
    private String seatsNumber;

}
