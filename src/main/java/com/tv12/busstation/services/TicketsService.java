package com.tv12.busstation.services;

import com.tv12.busstation.entities.Ticket;

public interface TicketsService {
    void create(String surname, String name, String phone, String email,
                int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price);

    Iterable<Ticket> getByJourneyId(int journeyId);

    void update(int id, String surname, String name, String phone, String email,
                int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price);

    void delete(int id);
}
