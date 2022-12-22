package com.tv12.busstation.services;

import com.tv12.busstation.entities.City;

public interface CitiesService {
    void create(String name);
    Iterable<City> readAll();
    void update(int id, String name);
    void delete(Integer id);
}
