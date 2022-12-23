package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.services.CitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final CitiesService citiesService;

    public MainController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/")
    public ModelAndView main() {
        MainModel model = new MainModel();
        model.setCities(citiesService.readAll());
        return model;
    }
}
