package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "stops")
public class Stop {
    @Id
    @Column(value = "id")
    private int id;

    @Column(value = "route_id")
    private Route route;

    @Column(value = "city_id")
    private City city;

    @Column(value = "time")
    private Time time;

    @Column(value = "price")
    private int price;

    @Column(value = "day_shift")
    private int dayShift;

    @Override
    public String toString() {
        return "Stop at " + city.getName();
    }
}
