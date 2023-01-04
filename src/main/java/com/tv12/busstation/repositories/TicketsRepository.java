package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = """
                   """)
    List<Ticket> someMethod();
}
