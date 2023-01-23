package com.tv12.busstation.services;

import com.tv12.busstation.entities.JourneyStop;

public interface JourneyStopDAO {
    JourneyStop getByIds(int journeyId, int stopId);
}
