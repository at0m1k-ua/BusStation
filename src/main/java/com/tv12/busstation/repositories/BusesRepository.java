package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BusesRepository extends JpaRepository<Bus, Integer> {
}
