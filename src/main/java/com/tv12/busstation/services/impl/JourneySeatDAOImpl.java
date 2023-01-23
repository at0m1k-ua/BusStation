package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.repositories.JourneySeatsRepository;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.repositories.JourneysRepository;
import com.tv12.busstation.services.JourneySeatDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JourneySeatDAOImpl implements JourneySeatDAO {

    private final JourneysRepository journeysRepository;
    private final JourneySeatsRepository journeySeatsRepository;
    private final JourneyStopsRepository journeyStopsRepository;

    public JourneySeatDAOImpl(JourneysRepository journeysRepository,
                              JourneySeatsRepository journeySeatsRepository,
                              JourneyStopsRepository journeyStopsRepository) {
        this.journeysRepository = journeysRepository;
        this.journeySeatsRepository = journeySeatsRepository;
        this.journeyStopsRepository = journeyStopsRepository;
    }

    @Override
    public List<Integer> getAvailableSeats(int journeyId, int stopIdFrom, int stopIdTo) {
        Journey journey = journeysRepository.findById(journeyId).get();
        int seatsNumber = journey.getBus().getModel().getSeatsNumber();

        JourneyStop from = journeyStopsRepository.getJourneyStop(journeyId, stopIdFrom);
        JourneyStop to = journeyStopsRepository.getJourneyStop(journeyId, stopIdTo);

        List<Integer> availableSeats = new ArrayList<>();
        for (int i = 1; i <= seatsNumber; i++) {
            if (journeySeatsRepository.seatIsBusy(journeyId, i, from.getTimestamp(), to.getTimestamp()) == 0) {
                availableSeats.add(i);
            }
        }

        return availableSeats;
    }
}
