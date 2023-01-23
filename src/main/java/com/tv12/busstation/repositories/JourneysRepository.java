package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Journey;
import org.springframework.data.repository.CrudRepository;

public interface JourneysRepository extends CrudRepository<Journey, Integer> {
}
