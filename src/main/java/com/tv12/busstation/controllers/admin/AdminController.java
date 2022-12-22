package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.AdminModel;
import com.tv12.busstation.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new AdminModel();
    }
}
