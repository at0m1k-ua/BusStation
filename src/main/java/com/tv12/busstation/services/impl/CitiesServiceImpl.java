package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.City;
import com.tv12.busstation.repositories.CitiesRepository;
import com.tv12.busstation.services.CitiesService;
import org.springframework.stereotype.Service;

@Service
public class CitiesServiceImpl implements CitiesService {

    public final CitiesRepository citiesRepository;

    public CitiesServiceImpl(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(String name) {
        citiesRepository.saveAndFlush(new City(null, name));
    }

    @Override
    public Iterable<City> readAll() {
        return citiesRepository.findAllByOrderByNameAsc();
    }

    @Override
    public void update(int id, String name) {
        City city = citiesRepository.findById(id).get();
        city.setName(name);
        citiesRepository.saveAndFlush(city);
    }

    @Override
    public void delete(Integer id) {
        citiesRepository.deleteById(id);
    }
}
