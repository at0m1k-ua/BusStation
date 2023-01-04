package com.tv12.busstation.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketsController {

    @GetMapping("/admin/tickets")
    public String read() {
        return "admin/tickets";
    }
}
