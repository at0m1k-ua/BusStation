package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.JourneysModel;
import com.tv12.busstation.services.BusDAO;
import com.tv12.busstation.services.DriverDAO;
import com.tv12.busstation.services.JourneyDAO;
import com.tv12.busstation.services.RouteDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class JourneysController {

    private final JourneyDAO journeysService;
    private final RouteDAO routeDAO;
    private final BusDAO busesDAO;
    private final DriverDAO driversService;

    public JourneysController(JourneyDAO journeyDAO,
                              RouteDAO routeDAO,
                              BusDAO busDAO,
                              DriverDAO driverDAO) {
        this.journeysService = journeyDAO;
        this.routeDAO = routeDAO;
        this.busesDAO = busDAO;
        this.driversService = driverDAO;
    }

    @PostMapping("/admin/journeys")
    public String create(@RequestParam int routeId,
                         @RequestParam int busId,
                         @RequestParam int driverId,
                         @RequestParam Date startDate) {
        journeysService.create(routeId, busId, driverId, startDate);
        return "redirect:/admin/journeys";
    }

    @GetMapping("/admin/journeys")
    public ModelAndView read() {
        JourneysModel model = new JourneysModel();
        model.setJourneys(journeysService.readAll());
        model.setRoutes(routeDAO.readAll());
        model.setBuses(busesDAO.readAll());
        model.setDrivers(driversService.readAll());
        return model;
    }

    @PatchMapping("/admin/journeys")
    public String update(@RequestParam int id,
                         @RequestParam int routeId,
                         @RequestParam int busId,
                         @RequestParam int driverId,
                         @RequestParam Date startDate) {
        journeysService.update(id, routeId, busId, driverId, startDate);
        return "redirect:/admin/journeys";
    }

    @DeleteMapping("/admin/journeys")
    public String delete(@RequestParam int id) {
        journeysService.delete(id);
        return "redirect:/admin/journeys";
    }
}
