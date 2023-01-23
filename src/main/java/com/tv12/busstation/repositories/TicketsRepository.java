package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketsRepository extends CrudRepository<Ticket, Integer> {
    List<Ticket> findAllByJourneyId(int journeyId);
}
