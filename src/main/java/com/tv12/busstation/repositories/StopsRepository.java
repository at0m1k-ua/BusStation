package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepository extends JpaRepository<Stop, Integer> {

}
