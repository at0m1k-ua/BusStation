package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "journey_seats")
public class JourneySeat implements Serializable {
    @Id
    @Column(value = "ticket_id")
    private Ticket ticket;

    @Column(value = "journey_id")
    private Journey journey;

    @Column(value = "stop_id_from")
    private Stop from;

    @Column(value = "stop_id_to")
    private Stop to;

    @Column(value = "timestamp_from")
    private Timestamp timestampFrom;

    @Column(value = "timestamp_to")
    private Timestamp timestampTo;
}
