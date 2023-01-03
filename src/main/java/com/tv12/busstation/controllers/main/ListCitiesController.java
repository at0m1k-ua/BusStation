package com.tv12.busstation.controllers.main;

import com.tv12.busstation.entities.City;
import com.tv12.busstation.services.CitiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListCitiesController {

    private final CitiesService citiesService;

    public ListCitiesController(CitiesService citiesService) {
        this.citiesService = citiesService;
    }

    @GetMapping("/listCities")
    public ResponseEntity<List<String>> getAll() {
        return new ResponseEntity<>(
                citiesService.readAll().stream().map(City::getName).toList(),
                HttpStatus.OK
        );
    }
}
