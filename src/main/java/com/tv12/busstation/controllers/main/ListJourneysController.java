package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.sql.Date;

@Controller
public class ListJourneysController {

    private final static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("M/d/yyyy")
            .toFormatter();

    @GetMapping("/listJourneys")
    public ModelAndView listJourneys(@RequestParam String from,
                                     @RequestParam String to,
                                     @RequestParam("startDate") String startDateString) {
        Date startDate = Date.valueOf(LocalDate.parse(startDateString, formatter));

        MainModel mainModel = new MainModel();
        mainModel.setFrom(from);
        mainModel.setTo(to);
        mainModel.setStartDate(startDate);

        return mainModel;
    }
}
