package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.Bus;
import com.tv12.busstation.entities.Driver;
import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Route;
import org.springframework.web.servlet.ModelAndView;

public class JourneysModel extends ModelAndView {
    public JourneysModel() {
        super("/admin/journeys");
    }

    public void setJourneys(Iterable<Journey> journeys) {
        addObject("journeys", journeys);
    }

    public void setRoutes(Iterable<Route> routes) {
        addObject("routes", routes);
    }

    public void setBuses(Iterable<Bus> buses) {
        addObject("buses", buses);
    }

    public void setDrivers(Iterable<Driver> drivers) {
        addObject("drivers", drivers);
    }
}
