package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<Passenger, Integer> {
}
