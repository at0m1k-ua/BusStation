package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Ticket;
import com.tv12.busstation.services.PendingTicketStorage;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class PendingTicketStorageImpl implements PendingTicketStorage {

    private final ConcurrentMap<String, Ticket> tickets = new ConcurrentHashMap<>();

    @Override
    public void addTicket(String alias, Ticket ticket) {
        // let it be there to avoid creating a separate thread
        cleanTickets();

        tickets.put(alias, ticket);
    }

    @Override
    public Ticket getTicket(String alias) {
        return tickets.get(alias);
    }

    @Override
    public void deleteTicket(String alias) {
        tickets.remove(alias);
    }

    public void cleanTickets() {
        for (var entry : tickets.entrySet()) {
            String alias = entry.getKey();
            Ticket ticket = entry.getValue();
            Instant createdAt = ticket.getCreatedAt().toInstant();
            if (createdAt.plusSeconds(10 * 60).compareTo(Instant.now()) < 0) {
                tickets.remove(alias);
            }
        }
    }
}
