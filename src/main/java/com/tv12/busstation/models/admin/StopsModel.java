package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.City;
import com.tv12.busstation.entities.Stop;
import org.springframework.web.servlet.ModelAndView;

public class StopsModel extends ModelAndView {

    public StopsModel() {
        super("/admin/stops");
    }

    public void setStops(Iterable<Stop> stops) {
        addObject("stops", stops);
    }

    public void setCities(Iterable<City> cities) {
        addObject("cities", cities);
    }

    public void setRouteId(Integer routeId) {
        addObject("routeId", routeId);
    }
}
