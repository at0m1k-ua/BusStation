package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView main() {
        return new MainModel();
    }
}
