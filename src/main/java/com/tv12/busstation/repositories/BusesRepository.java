package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusesRepository extends CrudRepository<Bus, Integer> {
}
