package com.tv12.busstation.domain.ui;

import com.tv12.busstation.domain.Trip;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public final class UiTrip {
    private final Integer journeyId;
    private final String cityFrom;
    private final String dateFrom;
    private final String timeFrom;
    private final String cityTo;
    private final String dateTo;
    private final String timeTo;
    private final int price;
    private static final List<String> daysOfWeek = List.of(
            "Понеділок",
            "Вівторок",
            "Середа",
            "Четвер",
            "П'ятниця",
            "Субота",
            "Неділя"
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

        this.journeyId = trip.getJourney().getId();
        this.cityFrom = trip.getStopFrom().getCity().getName();
        Date standardDateFrom = Date.valueOf(trip.getTimestampFrom().toLocalDateTime().toLocalDate());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(standardDateFrom);
        this.dateFrom = String.format("%s, %d %s",
                daysOfWeek.get(calendar.get(Calendar.DAY_OF_WEEK)),
                calendar.get(Calendar.DAY_OF_MONTH),
                monthOfYear.get(calendar.get(Calendar.MONTH)));
        this.timeFrom = trip.getTimestampFrom().toLocalDateTime().toLocalTime().toString();
        this.cityTo = trip.getStopTo().getCity().getName();
        this.dateTo = trip.getTimestampTo().toLocalDateTime().toLocalDate().toString();
        this.timeTo = trip.getTimestampTo().toLocalDateTime().toLocalTime().toString();
        this.price = trip.getPrice();
    }
}
