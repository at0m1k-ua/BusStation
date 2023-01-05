package com.tv12.busstation.services;

import com.tv12.busstation.entities.JourneyStop;

public interface JourneyStopsService {
    JourneyStop getByIds(int journeyId, int stopId);
}
