package com.tv12.busstation.services.impl;

import com.tv12.busstation.domain.Trip;
import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.repositories.TicketsRepository;
import com.tv12.busstation.services.TripsService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TripsServiceImpl implements TripsService {

    private final JourneyStopsRepository journeyStopsRepository;
    private final TicketsRepository ticketsRepository;

    public TripsServiceImpl(JourneyStopsRepository journeyStopsRepository,
                            TicketsRepository ticketsRepository) {
        this.journeyStopsRepository = journeyStopsRepository;
        this.ticketsRepository = ticketsRepository;
    }

    public List<Trip> getTrips(String from, String to, Date date) {
        return journeyStopsRepository
                .getFromJourneyStops(from, to, date.toString())
                .stream().map((journeyStopFrom) -> {
                    Trip trip = new Trip();
                    trip.setJourney(journeyStopFrom.getId().getJourney());
                    trip.setStopFrom(journeyStopFrom.getId().getStop());
                    trip.setTimestampFrom(journeyStopFrom.getTimestamp());

                    JourneyStop journeyStopTo = journeyStopsRepository
                            .getToJourneyStop(trip.getJourney().getId(), to, journeyStopFrom.getTimestamp());

                    trip.setStopTo(journeyStopTo.getId().getStop());
                    trip.setTimestampTo(journeyStopTo.getTimestamp());
                    trip.setPrice(journeyStopsRepository.getPrice(
                            trip.getJourney().getId(),
                            trip.getTimestampFrom(),
                            trip.getTimestampTo())
                    );
                    return trip;
                }).toList();
    }

    public List<Integer> getFreeSeats(Trip trip) {
        return null;
    }
}
