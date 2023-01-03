package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "journey_stops")
public class JourneyStop {
    @EmbeddedId
    private JourneyStopPrimaryKey id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "timestamp")
    private Timestamp timestamp;
}
