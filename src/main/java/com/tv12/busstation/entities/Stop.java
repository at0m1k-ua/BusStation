package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stops")
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false, columnDefinition = "INT")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, columnDefinition = "INT")
    private City city;

    @Column(name = "time", nullable = false, columnDefinition = "TIME")
    private Time time;

    @Column(name = "price", nullable = false, columnDefinition = "INT")
    private int price;

    @Column(name = "day_shift", nullable = false, columnDefinition = "INT")
    private int dayShift;

    @Override
    public String toString() {
        return "Stop at " + city.getName();
    }
}
