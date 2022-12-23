package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    boolean existsByName(String name);
    Iterable<City> findAllByOrderByNameAsc();
}
