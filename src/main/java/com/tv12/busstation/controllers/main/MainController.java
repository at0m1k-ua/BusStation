package com.tv12.busstation.controllers.main;

import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.repositories.JourneyStopsRepository;
import com.tv12.busstation.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    private final CitiesService citiesService;

    public MainController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @Autowired
    JourneyStopsRepository journeyStopsRepository;

    @GetMapping("/")
    public ModelAndView main() {
        MainModel model = new MainModel();
        model.setCities(citiesService.readAll());

        List<JourneyStop> fromStops = journeyStopsRepository.getFromJourneyStops("Миколаїв", "2023-03-02", "Житомир");

        for (var entry : fromStops) {
            System.out.println(entry.getCityName() + " " +
                               entry.getId().getJourney().getId() + " " +
                               entry.getId().getStop().getId() + " " +
                               entry.getTimestamp());
            JourneyStop toStop = journeyStopsRepository.getToJourneyStop(
                    entry.getId().getJourney().getId(),
                    "Київ",
                    entry.getTimestamp()
            );
            System.out.println(toStop.getCityName() + " " +
                               toStop.getId().getJourney().getId() + " " +
                               toStop.getId().getStop().getId() + " " +
                               toStop.getTimestamp());
            System.out.println();
        }

        return model;
    }
}
