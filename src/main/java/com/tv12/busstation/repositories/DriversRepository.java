package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository extends JpaRepository<Driver, Integer> {
}
