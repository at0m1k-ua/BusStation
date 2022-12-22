package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.City;
import org.springframework.web.servlet.ModelAndView;

public class CitiesModel extends ModelAndView {

    public CitiesModel() {
        super("/admin/cities");
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }

}
