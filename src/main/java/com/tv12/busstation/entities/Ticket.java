package com.tv12.busstation.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false, columnDefinition = "INT")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false, columnDefinition = "INT")
    private Route route;

    @Column(name = "seat_number", nullable = false, columnDefinition = "INT")
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "stop_number_from", nullable = false, columnDefinition = "INT")
    private Stop from;

    @ManyToOne
    @JoinColumn(name = "stop_number_to", nullable = false, columnDefinition = "INT")
    private Stop to;
}
