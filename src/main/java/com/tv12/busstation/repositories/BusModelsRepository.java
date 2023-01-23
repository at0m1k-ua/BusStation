package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.BusModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusModelsRepository extends CrudRepository<BusModel, Integer> {
}
