package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.BusesModel;
import com.tv12.busstation.services.BusModelDAO;
import com.tv12.busstation.services.BusDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusesController {

    private final BusDAO busDAO;
    private final BusModelDAO busModelDAO;

    public BusesController(BusDAO busDAO,
                           BusModelDAO busModelDAO) {
        this.busDAO = busDAO;
        this.busModelDAO = busModelDAO;
    }

    @PostMapping("/admin/buses")
    public String create(@RequestParam int modelId,
                         @RequestParam String color,
                         @RequestParam String licensePlateNumber){
        busDAO.create(modelId, color, licensePlateNumber);
        return "redirect:/admin/buses";
    }

    @PostMapping("/admin/buses/models")
    public String createBusModel(@RequestParam String name,
                                 @RequestParam int seatsNumber) {
        busModelDAO.create(name, seatsNumber);
        return "redirect:/admin/buses";
    }

    @GetMapping("/admin/buses")
    public ModelAndView read() {
        BusesModel model = new BusesModel();
        model.setBuses(busDAO.readAll());
        model.setBusModels(busModelDAO.readAll());
        return model;
    }

    @PatchMapping("/admin/buses")
    public String update(@RequestParam int id,
                         @RequestParam int modelId,
                         @RequestParam String color,
                         @RequestParam String licensePlateNumber) {
        busDAO.update(id, modelId, color, licensePlateNumber);
        return "redirect:/admin/buses";
    }

    @DeleteMapping("/admin/buses")
    public String delete(@RequestParam int id) {
        busDAO.delete(id);
        return "redirect:/admin/buses";
    }
}
