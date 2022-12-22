package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.repositories.CitiesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class ListJourneysController {

    private final CitiesRepository citiesRepository;

    public ListJourneysController(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @GetMapping("/listJourneys")
    public ModelAndView listJourneys(@RequestParam("from") String from,
                                     @RequestParam("to") String to,
                                     @RequestParam("date") Date date,
                                     @RequestParam("passengers") int passengers){
        MainModel mainModel = new MainModel();

        if (!citiesRepository.existsByName(from)) {
            return mainModel.addWrongCity(from);
        }

        if (!citiesRepository.existsByName(to)) {
            return mainModel.addWrongCity(to);
        }

        return mainModel;
    }
}
