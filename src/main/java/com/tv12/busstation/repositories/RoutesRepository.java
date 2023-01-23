package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Route;
import org.springframework.data.repository.CrudRepository;

public interface RoutesRepository extends CrudRepository<Route, Integer> {
}
