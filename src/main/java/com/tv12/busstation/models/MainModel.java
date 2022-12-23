package com.tv12.busstation.models;

import com.tv12.busstation.entities.City;
import org.springframework.web.servlet.ModelAndView;

public class MainModel extends ModelAndView {

    public MainModel() {
        super("main");
    }

    public void addWrongCity(String wrongCity) {
        addObject("wrong_city", wrongCity);
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }
}
