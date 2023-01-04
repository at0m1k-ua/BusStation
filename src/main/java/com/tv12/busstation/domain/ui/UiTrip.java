package com.tv12.busstation.domain.ui;

import com.tv12.busstation.domain.Trip;

import java.sql.Date;
import java.util.*;

public record UiTrip(Integer journeyId,
                     String cityFrom,
                     String dateFrom,
                     String timeFrom,
                     String cityTo,
                     String dateTo,
                     String timeTo,
                     int price) {
    private static final List<String> daysOfWeek = List.of(
            "Неділя",
            "Понеділок",
            "Вівторок",
            "Середа",
            "Четвер",
            "П'ятниця",
            "Субота"
    );
    private static final List<String> monthOfYear = List.of(
            "січня",
            "лютого",
            "березня",
            "квітня",
            "травня",
            "червня",
            "липня",
            "серпня",
            "вересня",
            "жовтня",
            "листопада",
            "грудня"
    );

    public UiTrip(Trip trip) {
        this(
            trip.getJourney().getId(),
            trip.getStopFrom().getCity().getName(),
            formatDate(Date.valueOf(trip.getTimestampFrom().toLocalDateTime().toLocalDate())),
            trip.getTimestampFrom().toLocalDateTime().toLocalTime().toString(),
            trip.getStopTo().getCity().getName(),
            formatDate(Date.valueOf(trip.getTimestampTo().toLocalDateTime().toLocalDate().toString())),
            trip.getTimestampTo().toLocalDateTime().toLocalTime().toString(),
            trip.getPrice()
        );
    }

    private static String formatDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.format("%s, %d %s",
                daysOfWeek.get(calendar.get(Calendar.DAY_OF_WEEK) - 1),
                calendar.get(Calendar.DAY_OF_MONTH),
                monthOfYear.get(calendar.get(Calendar.MONTH)));
    }
}
