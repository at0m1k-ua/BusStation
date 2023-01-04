package com.tv12.busstation.controllers.main;

import com.tv12.busstation.domain.ui.UiTrip;
import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.services.TripsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.sql.Date;

@Controller
public class ListTripsController {

    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("M/d/yyyy")
            .toFormatter();

    private final TripsService tripsService;

    public ListTripsController(TripsService tripsService) {
        this.tripsService = tripsService;
    }

    @GetMapping("/listTrips")
    public ModelAndView listJourneys(@RequestParam String from,
                                     @RequestParam String to,
                                     @RequestParam("startDate") String startDateString) {
        Date startDate = Date.valueOf(LocalDate.parse(startDateString, formatter));

        MainModel mainModel = new MainModel();
        mainModel.setFrom(from);
        mainModel.setTo(to);
        mainModel.setStartDate(startDate);
        mainModel.setTrips(
                tripsService.getTrips(from, to, startDate)
                        .stream()
                        .map((UiTrip::new))
                        .toList()
        );

        return mainModel;
    }
}
