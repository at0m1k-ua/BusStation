package com.tv12.busstation.entities;

import lombok.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buses")
@AccessType(AccessType.Type.PROPERTY)
@Builder
public class Bus {
    @Id
    @Column(value = "id")
    private Integer id;

    @Column(value = "model_id")
    private BusModel model;

    @Column(value = "color")
    private String color;

    @Column(value = "licence_plate_number")
    private String licencePlateNumber;

    @Override
    public String toString() {
        return this.color + " " + this.model.getName() + ", " + this.licencePlateNumber;
    }
}
