package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
public class TripPrimaryKey implements Serializable {
    @Column(value = "journey_id")
    private Journey journey;

    @Column(value = "from_stop_id")
    private Stop from;

    @Column(value = "to_stop_id")
    private Stop to;
}
