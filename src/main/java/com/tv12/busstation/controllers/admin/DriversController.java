package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.DriversModel;
import com.tv12.busstation.services.DriverDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DriversController {

    private final DriverDAO driverDAO;

    public DriversController(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    @PostMapping("/admin/drivers")
    public String create(@RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String patronymic,
                         @RequestParam String phone,
                         @RequestParam String email) {
        driverDAO.create(surname, name, patronymic, phone, email);
        return "redirect:/admin/drivers";
    }

    @GetMapping("/admin/drivers")
    public ModelAndView read() {
        DriversModel model = new DriversModel();
        model.setDrivers(driverDAO.readAll());
        return model;
    }

    @PatchMapping("/admin/drivers")
    public String update(@RequestParam int id,
                         @RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String patronymic,
                         @RequestParam String phone,
                         @RequestParam String email) {
        driverDAO.update(
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
        driverDAO.delete(id);
        return "redirect:/admin/drivers";
    }
}
