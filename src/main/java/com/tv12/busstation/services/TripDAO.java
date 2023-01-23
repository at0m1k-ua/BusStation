package com.tv12.busstation.services;

import com.tv12.busstation.entities.Trip;

import java.sql.Date;
import java.util.List;

public interface TripDAO {
    List<Trip> getTrips(String from, String to, Date date);
    int getPrice(Trip trip);
    int getPrice(int journeyId, int stopIdFrom, int stopIdTo);
}
