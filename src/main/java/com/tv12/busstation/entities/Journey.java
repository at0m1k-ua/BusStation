package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "journeys")
public class Journey {
    @Id
    @Column(value = "id")
    private Integer id;

    @Column(value = "route_id")
    private Route route;

    @Column(value = "bus_id")
    private Bus bus;

    @Column(value = "driver_id")
    private Driver driver;

    @Column(value = "start_date")
    private Date startDate;
}
