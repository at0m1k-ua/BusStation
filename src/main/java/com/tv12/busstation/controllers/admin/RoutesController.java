package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.RoutesModel;
import com.tv12.busstation.services.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoutesController {

    private final RoutesService routesService;

    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @PostMapping("/admin/routes")
    public String create() {
        int id = routesService.create();
        return "redirect:/admin/stops?routeId=" + id;
    }

    @GetMapping("/admin/routes")
    public ModelAndView read() {
        RoutesModel model = new RoutesModel();
        model.setRoutes(routesService.readAll());
        return model;
    }
}
