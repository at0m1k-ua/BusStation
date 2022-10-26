package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneysRepository extends JpaRepository<Journey, Integer> {
}
