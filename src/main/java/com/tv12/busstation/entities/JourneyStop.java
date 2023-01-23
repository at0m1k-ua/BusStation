package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "journey_stops")
public class JourneyStop {
    @Id
    @Embedded.Empty
    private JourneyStopPrimaryKey id;

    @Column(value = "city_name")
    private String cityName;

    @Column(value = "timestamp")
    private Timestamp timestamp;
}
