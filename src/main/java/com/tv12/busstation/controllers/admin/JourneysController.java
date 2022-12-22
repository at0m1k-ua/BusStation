package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.JourneysModel;
import com.tv12.busstation.services.BusesService;
import com.tv12.busstation.services.DriversService;
import com.tv12.busstation.services.JourneysService;
import com.tv12.busstation.services.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class JourneysController {

    private final JourneysService journeysService;
    private final RoutesService routesService;
    private final BusesService busesService;
    private final DriversService driversService;

    public JourneysController(JourneysService journeysService,
                              RoutesService routesService,
                              BusesService busesService,
                              DriversService driversService) {
        this.journeysService = journeysService;
        this.routesService = routesService;
        this.busesService = busesService;
        this.driversService = driversService;
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
        model.setRoutes(routesService.readAll());
        model.setBuses(busesService.readAll());
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
