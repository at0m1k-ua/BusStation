package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
}
