package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "trips")
public class Trip {
    @Id
    @Embedded.Empty
    private TripPrimaryKey id;

    @Column(value = "from_city_name")
    private String fromCityName;

    @Column(value = "to_city_name")
    private String toCityName;

    @Column(value = "from_timestamp")
    private Timestamp fromTimestamp;

    @Column(value = "to_timestamp")
    private Timestamp toTimestamp;
}
