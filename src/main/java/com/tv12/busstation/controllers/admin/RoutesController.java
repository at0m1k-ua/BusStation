package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.RoutesModel;
import com.tv12.busstation.services.RouteDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutesController {

    private final RouteDAO routeDAO;

    public RoutesController(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @PostMapping("/admin/routes")
    public String create() {
        int id = routeDAO.create();
        return "redirect:/admin/stops?routeId=" + id;
    }

    @GetMapping("/admin/routes")
    public ModelAndView read() {
        RoutesModel model = new RoutesModel();
        model.setRoutes(routeDAO.readAll());
        return model;
    }

    @DeleteMapping("/admin/routes")
    public String delete(@RequestParam int id) {
        routeDAO.delete(id);
        return "redirect:/admin/routes";
    }
}
