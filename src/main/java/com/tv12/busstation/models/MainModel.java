package com.tv12.busstation.models;

import org.springframework.web.servlet.ModelAndView;

public class MainModel extends ModelAndView {

    public MainModel() {
        super("main");
    }

    public MainModel addWrongCity(String wrongCity) {
        addObject("wrong_city", wrongCity);
        return this;
    }
}
