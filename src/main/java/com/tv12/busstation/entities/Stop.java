package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "stops"
)
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, columnDefinition = "BIG INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false, columnDefinition = "BIG INT")
    private Journey journeyId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, columnDefinition = "BIG INT")
    private City cityId;

    @Column(name = "time", nullable = false, columnDefinition = "TIMESTAMP")
    private Timestamp time;

    @Column(name = "price", nullable = false, columnDefinition = "FLOAT")
    private int price;
}
