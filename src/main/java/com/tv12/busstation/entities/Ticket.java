package com.tv12.busstation.entities;

import lombok.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(value = "id")
    private Integer id;

    @Column(value = "surname")
    private String surname;

    @Column(value = "name")
    private String name;

    @Column(value = "phone")
    private String phone;

    @Column(value = "email")
    private String email;


    @Column(value = "journey_id")
    private Journey journey;

    @Column(value = "seat_number")
    private int seatNumber;

    @Column(value = "stop_number_from")
    private Stop from;

    @Column(value = "stop_number_to")
    private Stop to;

    @Column(value = "price")
    private int price;

    @Column(value = "created_at")
    private Timestamp createdAt;
}
