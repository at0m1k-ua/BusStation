package com.tv12.busstation.services.impl;

import com.tv12.busstation.Trip;
import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.services.TripsService;

import java.sql.Date;
import java.util.List;

public class TripsServiceImpl implements TripsService {

    private final JourneyStopsRepository journeyStopsRepository;

    public TripsServiceImpl(JourneyStopsRepository journeyStopsRepository) {
        this.journeyStopsRepository = journeyStopsRepository;
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
                    return trip;
                }).toList();
    }
}
