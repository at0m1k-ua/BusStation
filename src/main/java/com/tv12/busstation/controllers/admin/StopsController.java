package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.StopsModel;
import com.tv12.busstation.services.CityDAO;
import com.tv12.busstation.services.RouteDAO;
import com.tv12.busstation.services.StopDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;

@Controller
public class StopsController {

    private final RouteDAO routeDAO;
    private final CityDAO citiesService;
    private final StopDAO stopDAO;

    public StopsController(RouteDAO routeDAO,
                           CityDAO citiesService,
                           StopDAO stopDAO) {
        this.routeDAO = routeDAO;
        this.citiesService = citiesService;
        this.stopDAO = stopDAO;
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
        stopDAO.create(routeId, cityId, dayShift, Time.valueOf(time), price);
        return "redirect:/admin/stops?routeId=" + routeId;
    }

    @GetMapping("/admin/stops")
    public ModelAndView read(@RequestParam int routeId) {
        StopsModel model = new StopsModel();
        model.setStops(routeDAO.getRouteStops(routeId));
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
        stopDAO.update(id, routeId, cityId, dayShift, time, price);
        return "redirect:/admin/stops?routeId=" + routeId;
    }

    @DeleteMapping("/admin/stops")
    public String delete(@RequestParam int id,
                         @RequestParam int routeId) {
        stopDAO.delete(id);
        return "redirect:/admin/stops?routeId=" + routeId;
    }
}
