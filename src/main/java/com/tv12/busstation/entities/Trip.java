package com.tv12.busstation.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "trips")
public class Trip {
    @EmbeddedId
    private TripPrimaryKey id;

    @Column(name = "from_city_name")
    private String fromCityName;

    @Column(name = "to_city_name")
    private String toCityName;

    @Column(name = "from_timestamp")
    private Timestamp fromTimestamp;

    @Column(name = "to_timestamp")
    private Timestamp toTimestamp;
}
