package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "journeys",
        uniqueConstraints = {@UniqueConstraint(name = "platform_number_constrain", columnNames = "platform_number")}
)
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, columnDefinition = "BIG INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false, columnDefinition = "BIG INT")
    private Bus busId;

    @Column(name = "platform_number", nullable = false, columnDefinition = "INT")
    private int platformNumber;
}
