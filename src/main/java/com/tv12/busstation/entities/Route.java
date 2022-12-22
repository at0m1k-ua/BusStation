package com.tv12.busstation.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private int id;

    @OneToMany(mappedBy = "route")
    @OrderBy(value = "day_shift asc, time asc")
    private List<Stop> stops;

    public Stop getFirstStop() {
        if (stops.isEmpty()) {
            return null;
        }

        return stops.get(0);
    }

    public Stop getLastStop() {
        if (stops.isEmpty()) {
            return null;
        }

        return stops.get(stops.size() - 1);
    }

    @Override
    public String toString() {
        if (stops.isEmpty()) {
            return id + ": порожній маршрут";
        }

        return id + ": " + getFirstStop().getCity().getName()
                + " - " + getLastStop().getCity().getName();
    }
}
