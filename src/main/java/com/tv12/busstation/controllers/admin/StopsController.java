package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.StopsModel;
import com.tv12.busstation.services.CitiesService;
import com.tv12.busstation.services.RoutesService;
import com.tv12.busstation.services.StopsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;

@Controller
public class StopsController {

    private final RoutesService routesService;
    private final CitiesService citiesService;
    private final StopsService stopsService;

    public StopsController(RoutesService routesService,
                           CitiesService citiesService,
                           StopsService stopsService) {
        this.routesService = routesService;
        this.citiesService = citiesService;
        this.stopsService = stopsService;
    }

    @PostMapping("/admin/stops")
    public String create(@RequestParam int routeId,
                         @RequestParam int cityId,
                         @RequestParam int dayShift,
                         @RequestParam String time,
                         @RequestParam int price) {
        if (time.length() == 5) {  //hh:MM
            time += ":00";
        }
        stopsService.create(routeId, cityId, dayShift, Time.valueOf(time), price);
        return "redirect:/admin/stops?routeId=" + routeId;
    }

    @GetMapping("/admin/stops")
    public ModelAndView read(@RequestParam int routeId) {
        StopsModel model = new StopsModel();
        model.setStops(routesService.getRouteStops(routeId));
        model.setCities(citiesService.readAll());
        model.setRouteId(routeId);
        return model;
    }

    @PatchMapping("/admin/stops")
    public String update(@RequestParam int id,
                         @RequestParam int routeId,
                         @RequestParam int cityId,
                         @RequestParam int dayShift,
                         @RequestParam Time time,
                         @RequestParam int price) {
        stopsService.update(id, routeId, cityId, dayShift, time, price);
        return "redirect:/admin/stops?routeId=" + routeId;
    }

    @DeleteMapping("/admin/stops")
    public String delete(@RequestParam int id,
                         @RequestParam int routeId) {
        stopsService.delete(id);
        return "redirect:/admin/stops?routeId=" + routeId;
    }
}
