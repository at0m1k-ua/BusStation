package com.tv12.busstation.services;

import com.tv12.busstation.entities.Journey;

import java.sql.Date;

public interface JourneyDAO {
    void create(int routeId, int busId, int driverId, Date startDate);
    Iterable<Journey> readAll();
    Journey readById(int id);
    void update(int id, int routeId, int busId, int driverId, Date startDate);
    void delete(int id);
}
