package com.tv12.busstation.entities;

import lombok.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "routes")
public class Route {
    @Id
    @Column(value = "id")
    private int id;

    @MappedCollection(idColumn = "route_id")
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
