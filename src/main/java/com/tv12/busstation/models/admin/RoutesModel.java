package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.Route;
import org.springframework.web.servlet.ModelAndView;

public class RoutesModel extends ModelAndView {

    public RoutesModel() {
        super("/admin/routes");
    }

    public void setRoutes(Iterable<Route> routes) {
        addObject("routes", routes);
    }
}
