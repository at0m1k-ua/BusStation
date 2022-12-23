package com.tv12.busstation.services;

import com.tv12.busstation.entities.City;

import java.util.List;

public interface CitiesService {
    void create(String name);
    List<City> readAll();
    void update(int id, String name);
    void delete(Integer id);
}
