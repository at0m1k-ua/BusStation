package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.DriversModel;
import com.tv12.busstation.services.DriversService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DriversController {

    private final DriversService driversService;

    public DriversController(DriversService driversService) {
        this.driversService = driversService;
    }

    @PostMapping("/admin/drivers")
    public String create(@RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String patronymic,
                         @RequestParam String phone,
                         @RequestParam String email) {
        driversService.create(surname, name, patronymic, phone, email);
        return "redirect:/admin/drivers";
    }

    @GetMapping("/admin/drivers")
    public ModelAndView read() {
        DriversModel model = new DriversModel();
        model.setDrivers(driversService.readAll());
        return model;
    }

    @PatchMapping("/admin/drivers")
    public String update(@RequestParam int id,
                         @RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String patronymic,
                         @RequestParam String phone,
                         @RequestParam String email) {
        driversService.update(
                id,
                surname,
                name,
                patronymic,
                phone,
                email
        );
        return "redirect:/admin/drivers";
    }

    @DeleteMapping("/admin/drivers")
    public String delete(@RequestParam int id) {
        driversService.delete(id);
        return "redirect:/admin/drivers";
    }
}
