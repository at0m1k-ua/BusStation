package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.services.TripDAO;
import com.tv12.busstation.ui.UiTrip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.sql.Date;
import java.time.format.DateTimeParseException;

@Controller
public class ListTripsController {

    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("M/d/yyyy")
            .toFormatter();

    private final TripDAO tripDAO;

    public ListTripsController(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    @GetMapping("/listTrips")
    public ModelAndView listJourneys(@RequestParam String from,
                                     @RequestParam String to,
                                     @RequestParam("startDate") String startDateString) {
        MainModel mainModel = new MainModel();

        try {
            Date startDate = Date.valueOf(LocalDate.parse(startDateString, formatter));
            mainModel.setFrom(from);
            mainModel.setTo(to);
            mainModel.setStartDate(startDate);
            mainModel.setTrips(
                    tripDAO.getTrips(from, to, startDate)
                            .stream()
                            .map(trip -> UiTrip.of(trip, tripDAO.getPrice(trip)))
                            .toList());

        } catch (DateTimeParseException e) {

        }
        return mainModel;
    }
}
