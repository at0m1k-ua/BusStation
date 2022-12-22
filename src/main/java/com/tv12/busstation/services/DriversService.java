package com.tv12.busstation.services;

import com.tv12.busstation.entities.Driver;

public interface DriversService {
    void create(String surname, String name, String patronymic, String phone, String email);
    Iterable<Driver> readAll();
    void update(int id, String surname, String name, String patronymic, String phone, String email);
    void delete(int id);
}
