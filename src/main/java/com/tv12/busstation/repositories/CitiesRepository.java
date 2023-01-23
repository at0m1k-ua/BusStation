package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends CrudRepository<City, Integer> {
    List<City> findAllByOrderByNameAsc();
}
