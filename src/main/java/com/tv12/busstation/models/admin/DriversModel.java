package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.Driver;
import org.springframework.web.servlet.ModelAndView;

public class DriversModel extends ModelAndView {
    public DriversModel() {
        super("/admin/drivers");
    }

    public void setDrivers(Iterable<Driver> drivers) {
        addObject("drivers", drivers);
    }
}
