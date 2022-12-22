package com.tv12.busstation.services;

import com.tv12.busstation.entities.Journey;

import java.sql.Date;

public interface JourneysService {
    void create(int routeId, int busId, int driverId, Date startDate);
    Iterable<Journey> readAll();
    void update(int id, int routeId, int busId, int driverId, Date startDate);
    void delete(int id);
}
