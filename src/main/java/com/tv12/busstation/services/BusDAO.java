package com.tv12.busstation.services;

import com.tv12.busstation.entities.Bus;

public interface BusDAO {
    void create(int modelId, String color, String licensePlateNumber);
    Iterable<Bus> readAll();
    void update(int id, int modelId, String color, String licensePlateNumber);
    void delete(int id);
}
