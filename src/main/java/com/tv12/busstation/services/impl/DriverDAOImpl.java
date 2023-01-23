package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Driver;
import com.tv12.busstation.repositories.DriversRepository;
import com.tv12.busstation.services.DriverDAO;
import org.springframework.stereotype.Service;

@Service
public class DriverDAOImpl implements DriverDAO {

    private final DriversRepository driversRepository;

    public DriverDAOImpl(DriversRepository driversRepository) {
        this.driversRepository = driversRepository;
    }

    @Override
    public void create(String surname,
                       String name,
                       String patronymic,
                       String phone,
                       String email) {
        driversRepository.save(new Driver(
                null,
                surname,
                name,
                patronymic,
                phone,
                email
        ));
    }

    @Override
    public Iterable<Driver> readAll() {
        return driversRepository.findAll();
    }

    @Override
    public void update(int id,
                       String surname,
                       String name,
                       String patronymic,
                       String phone,
                       String email) {
        Driver driver = driversRepository.findById(id).get();
        driver.setSurname(surname);
        driver.setName(name);
        driver.setPatronymic(patronymic);
        driver.setPhone(phone);
        driver.setEmail(email);
        driversRepository.save(driver);
    }

    @Override
    public void delete(int id) {
        driversRepository.deleteById(id);
    }
}
