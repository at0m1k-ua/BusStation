package com.tv12.busstation.ui;

import com.tv12.busstation.entities.Trip;

import java.sql.Date;
import java.util.*;

public record UiTrip(Integer journeyId,
                     Integer stopIdFrom,
                     String cityFrom,
                     String dateFrom,
                     String timeFrom,
                     Integer stopIdTo,
                     String cityTo,
                     String dateTo,
                     String timeTo,
                     int price) {


    public static UiTrip of(Trip trip, int price) {
        UiDateTime from = new UiDateTime(trip.getFromTimestamp());
        UiDateTime to = new UiDateTime(trip.getToTimestamp());
        return new UiTrip(
            trip.getId().getJourney().getId(),
            trip.getId().getFrom().getId(),
            trip.getFromCityName(),
            from.getStringDate(),
            from.getStringTime(),
            trip.getId().getTo().getId(),
            trip.getToCityName(),
            to.getStringDate(),
            to.getStringTime(),
            price
        );
    }
}
