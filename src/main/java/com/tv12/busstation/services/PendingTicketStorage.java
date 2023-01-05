package com.tv12.busstation.services;

import com.tv12.busstation.entities.Ticket;

public interface PendingTicketStorage {
    void addTicket(String alias, Ticket ticket);
    Ticket getTicket(String alias);
    void deleteTicket(String tempId);
}
