package com.tv12.busstation.services;

import com.tv12.busstation.entities.BusModel;

public interface BusModelsService {
    void create(String name, int seatsNumber);
    Iterable<BusModel> readAll();
}
