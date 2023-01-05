package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Stop;
import com.tv12.busstation.entities.Trip;
import com.tv12.busstation.entities.TripPrimaryKey;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.repositories.JourneysRepository;
import com.tv12.busstation.repositories.StopsRepository;
import com.tv12.busstation.repositories.TripsRepository;
import com.tv12.busstation.services.TripsService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TripsServiceImpl implements TripsService {

    private final TripsRepository tripsRepository;
    private final JourneyStopsRepository journeyStopsRepository;
    private final JourneysRepository journeysRepository;
    private final StopsRepository stopsRepository;

    public TripsServiceImpl(TripsRepository tripsRepository,
                            JourneyStopsRepository journeyStopsRepository,
                            JourneysRepository journeysRepository,
                            StopsRepository stopsRepository) {
        this.tripsRepository = tripsRepository;
        this.journeyStopsRepository = journeyStopsRepository;
        this.journeysRepository = journeysRepository;
        this.stopsRepository = stopsRepository;
    }

    public List<Trip> getTrips(String from, String to, Date date) {
        return tripsRepository.findByCitiesAndDepartureDate(from, to, date);
    }

    public int getPrice(Trip trip) {
        return journeyStopsRepository.getTripPrice(
                trip.getId().getJourney().getId(),
                trip.getFromTimestamp(),
                trip.getToTimestamp()
        );
    }

    @Override
    public int getPrice(int journeyId, int stopIdFrom, int stopIdTo) {
        Journey journey = journeysRepository.getReferenceById(journeyId);
        Stop from = stopsRepository.getReferenceById(stopIdFrom);
        Stop to = stopsRepository.getReferenceById(stopIdTo);

        Trip trip = tripsRepository.getReferenceById(new TripPrimaryKey(journey, from, to));
        return getPrice(trip);
    }

    public List<Integer> getFreeSeats(Trip trip) {
        return null;
    }
}
