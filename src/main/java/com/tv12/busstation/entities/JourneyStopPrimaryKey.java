package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.relational.core.mapping.Column;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
public class JourneyStopPrimaryKey{
    @Column(value = "journey_id")
    private Journey journey;

    @Column(value = "stop_id")
    private Stop stop;
}
