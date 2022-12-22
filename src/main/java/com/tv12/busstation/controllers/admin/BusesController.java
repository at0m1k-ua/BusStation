package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.BusesModel;
import com.tv12.busstation.services.BusModelsService;
import com.tv12.busstation.services.BusesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusesController {

    private final BusesService busesService;
    private final BusModelsService busModelsService;

    public BusesController(BusesService busesService,
                           BusModelsService busModelsService) {
        this.busesService = busesService;
        this.busModelsService = busModelsService;
    }

    @PostMapping("/admin/buses")
    public String create(@RequestParam int modelId,
                         @RequestParam String color,
                         @RequestParam String licensePlateNumber){
        busesService.create(modelId, color, licensePlateNumber);
        return "redirect:/admin/buses";
    }

    @PostMapping("/admin/buses/models")
    public String createBusModel(@RequestParam String name,
                                 @RequestParam int seatsNumber) {
        busModelsService.create(name, seatsNumber);
        return "redirect:/admin/buses";
    }

    @GetMapping("/admin/buses")
    public ModelAndView read() {
        BusesModel model = new BusesModel();
        model.setBuses(busesService.readAll());
        model.setBusModels(busModelsService.readAll());
        return model;
    }

    @PatchMapping("/admin/buses")
    public String update(@RequestParam int id,
                         @RequestParam int modelId,
                         @RequestParam String color,
                         @RequestParam String licensePlateNumber) {
        busesService.update(id, modelId, color, licensePlateNumber);
        return "redirect:/admin/buses";
    }

    @DeleteMapping("/admin/buses")
    public String delete(@RequestParam int id) {
        busesService.delete(id);
        return "redirect:/admin/buses";
    }
}
