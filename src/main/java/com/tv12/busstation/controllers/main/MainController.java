package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.MainModel;
import com.tv12.busstation.services.impl.EmailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView main() {

        EmailSenderImpl emailSender = new EmailSenderImpl();
        emailSender.sendHtml("I want to break free", "kuruch2004@gmail.com");

        return new MainModel();
    }
}
