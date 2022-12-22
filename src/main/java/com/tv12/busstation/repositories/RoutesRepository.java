package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<Route, Integer> {
}
