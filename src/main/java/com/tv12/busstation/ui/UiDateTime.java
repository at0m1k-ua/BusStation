package com.tv12.busstation.ui;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public class UiDateTime {

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

    private static final List<String> daysOfWeek = List.of(
            "Неділя",
            "Понеділок",
            "Вівторок",
            "Середа",
            "Четвер",
            "П'ятниця",
            "Субота"
    );

    private Date date;
    private Time time;

    public UiDateTime(Timestamp timestamp) {
        LocalDateTime dateTime = timestamp.toLocalDateTime();
        this.date = Date.valueOf(dateTime.toLocalDate());
        this.time = Time.valueOf(dateTime.toLocalTime());
    }

    public String getStringDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.format("%s, %d %s",
                daysOfWeek.get(calendar.get(Calendar.DAY_OF_WEEK) - 1),
                calendar.get(Calendar.DAY_OF_MONTH),
                monthOfYear.get(calendar.get(Calendar.MONTH)));
    }

    public String getStringTime() {
        return time.toString();
    }

    @Override
    public String toString() {
        return getStringDate() + " " + getStringTime();
    }
}
