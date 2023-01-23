package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.City;
import com.tv12.busstation.repositories.CitiesRepository;
import com.tv12.busstation.services.CityDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CityDAO {

    public final CitiesRepository citiesRepository;

    public CitiesServiceImpl(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(String name) {
        citiesRepository.save(new City(null, name));
    }

    @Override
    public List<City> readAll() {
        return citiesRepository.findAllByOrderByNameAsc();
    }

    @Override
    public void update(int id, String name) {
        City city = citiesRepository.findById(id).get();
        city.setName(name);
        citiesRepository.save(city);
    }

    @Override
    public void delete(Integer id) {
        citiesRepository.deleteById(id);
    }
}
