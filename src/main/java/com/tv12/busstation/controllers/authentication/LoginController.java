package com.tv12.busstation.controllers.authentication;

import com.tv12.busstation.models.AuthenticationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public ModelAndView returnModel() {
        return new AuthenticationModel();
    }
}
