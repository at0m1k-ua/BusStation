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
        name = "buses",
        uniqueConstraints = {@UniqueConstraint(name = "licence_plate_constraint", columnNames = "licence_plate_number")}
)
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, columnDefinition = "BIG INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false, columnDefinition = "BIG INT")
    private Bus modelId;

    @Column(name = "color", nullable = false, columnDefinition = "TEXT")
    private String color;

    @Column(name = "licence_plate_number", nullable = false, columnDefinition = "TEXT")
    private String licencePlateNumber;
}
