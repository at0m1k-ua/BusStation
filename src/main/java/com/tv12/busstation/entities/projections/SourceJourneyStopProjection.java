package com.tv12.busstation.entities.projections;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;

public interface SourceJourneyStopProjection {
    @Value("#{target.journey_id}")
    Integer getJourneyId();

    @Value("#{target.stop_id}")
    Integer getStopId();

    @Value("#{target.city_name}")
    Integer getCityName();

    Timestamp getTimestamp();
}
