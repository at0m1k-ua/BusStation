package com.tv12.busstation.models;

import org.springframework.web.servlet.ModelAndView;

public class AuthenticationModel extends ModelAndView {
    public AuthenticationModel() {
        super("/auth");
    }
    public void setEmail() {
        addObject("email");
    }

    public void setPassword() {
        addObject("password");
    }

}
