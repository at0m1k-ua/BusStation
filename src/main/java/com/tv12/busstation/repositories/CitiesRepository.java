package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    List<City> findAllByOrderByNameAsc();
}
