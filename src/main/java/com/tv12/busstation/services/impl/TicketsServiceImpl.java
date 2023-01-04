package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Stop;
import com.tv12.busstation.entities.Ticket;
import com.tv12.busstation.repositories.JourneysRepository;
import com.tv12.busstation.repositories.StopsRepository;
import com.tv12.busstation.repositories.TicketsRepository;
import com.tv12.busstation.services.TicketsService;
import org.springframework.stereotype.Service;

@Service
public class TicketsServiceImpl implements TicketsService {
    private final JourneysRepository journeysRepository;
    private final StopsRepository stopsRepository;
    private final TicketsRepository ticketsRepository;

    public TicketsServiceImpl(JourneysRepository journeysRepository,
                              StopsRepository stopsRepository,
                              TicketsRepository ticketsRepository){
        this.journeysRepository = journeysRepository;
        this.stopsRepository = stopsRepository;
        this.ticketsRepository = ticketsRepository;
    }
    @Override
    public void create(String surname, String name, String phone, String email,
                       int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        save(null, surname, name, phone, email, journeyId, seatNumber, stopNumberFrom, stopNumberTo, price);
    }

    @Override
    public void update(int id, String surname, String name, String phone, String email,
                       int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        save(id, surname, name, phone, email, journeyId, seatNumber, stopNumberFrom, stopNumberTo, price);
    }

    @Override
    public void delete(int id) {
        ticketsRepository.deleteById(id);
    }

    @Override
    public Iterable<Ticket> getByJourneyId(int journeyId) {
        return null;
    }

    private void save(Integer id, String surname, String name, String phone, String email,
                      int journeyId, int seatNumber, int stopNumberFrom, int stopNumberTo, int price) {
        Journey journey = journeysRepository.findById(journeyId).get();
        Stop stopFrom = stopsRepository.findById(stopNumberFrom).get();
        Stop stopTo = stopsRepository.findById(stopNumberTo).get();
        Ticket ticket = id == null ? new Ticket() : ticketsRepository.findById(id).get();

        ticket.setSurname(surname);
        ticket.setName(name);
        ticket.setPhone(phone);
        ticket.setEmail(email);
        ticket.setJourney(journey);
        ticket.setSeatNumber(seatNumber);
        ticket.setFrom(stopFrom);
        ticket.setTo(stopTo);
        ticket.setPrice(price);

    }
}
