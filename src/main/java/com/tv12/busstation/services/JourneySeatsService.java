package com.tv12.busstation.services;

import java.util.List;

public interface JourneySeatsService {
    List<Integer> getAvailableSeats(int journeyId, int stopIdFrom, int stopIdTo);
}
