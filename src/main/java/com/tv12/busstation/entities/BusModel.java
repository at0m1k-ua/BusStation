package com.tv12.busstation.entities;

import lombok.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bus_models")
@AccessType(AccessType.Type.PROPERTY)
public class BusModel {
    @Id
    @Column(value = "id")
    private Integer id;

    @Column(value = "name")
    private String name;

    @Column(value = "seats_number")
    private int seatsNumber;
}
