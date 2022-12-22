package com.tv12.busstation.services;

import java.sql.Time;

public interface StopsService {
    void create(int routeId, int cityId, int dayShift, Time time, int price);
    void update(int id, int routeId, int cityId, int dayShift, Time time, int price);
    void delete(int id);
}
