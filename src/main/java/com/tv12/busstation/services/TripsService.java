package com.tv12.busstation.services;

import com.tv12.busstation.domain.Trip;

import java.sql.Date;
import java.util.List;

public interface TripsService {
    List<Trip> getTrips(String from, String to, Date date);
}
