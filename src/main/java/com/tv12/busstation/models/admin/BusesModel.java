package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.Bus;
import com.tv12.busstation.entities.BusModel;
import org.springframework.web.servlet.ModelAndView;

public class BusesModel extends ModelAndView {
    public BusesModel() {
        super("/admin/buses");
    }

    public void setBuses(Iterable<Bus> buses) {
        addObject("buses", buses);
    }

    public void setBusModels(Iterable<BusModel> busModels) {
        addObject("bus_models", busModels);
    }
}
