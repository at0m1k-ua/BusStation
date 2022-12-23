package com.tv12.busstation.models;

import com.tv12.busstation.entities.City;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class MainModel extends ModelAndView {

    public MainModel() {
        super("main");
    }

    public void setFrom(String from) {
        addObject("from", from);
    }

    public void setTo(String to) {
        addObject("to", to);
    }

    public void setStartDate(Date startDate) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        addObject("startDate", dateFormat.format(startDate));
    }

    public void addWrongCity(String wrongCity) {
        addObject("wrong_city", wrongCity);
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }
}
