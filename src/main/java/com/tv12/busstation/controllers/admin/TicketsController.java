package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.TicketsModel;
import com.tv12.busstation.services.JourneysService;
import com.tv12.busstation.services.TicketsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketsController {

    private final TicketsService ticketsService;
    private final JourneysService journeysService;

    public TicketsController(TicketsService ticketsService,
                             JourneysService journeysService){
        this.ticketsService = ticketsService;
        this.journeysService = journeysService;
    }

    @PostMapping("/admin/tickets")
    public String create(@RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String phone,
                         @RequestParam String email,
                         @RequestParam int journeyId,
                         @RequestParam int seatNumber,
                         @RequestParam int stopNumberFrom,
                         @RequestParam int stopNumberTo,
                         @RequestParam int price) {
        ticketsService.create(
                surname,
                name,
                phone,
                email,
                journeyId,
                seatNumber,
                stopNumberFrom,
                stopNumberTo,
                price
        );
        return "redirect:/admin/tickets?journeyId=" + journeyId;
    }

    @GetMapping("/admin/tickets")
    public ModelAndView read(@RequestParam int journeyId) {
        TicketsModel ticketsModel = new TicketsModel();
        ticketsModel.setTickets(ticketsService.getByJourneyId(journeyId));
        ticketsModel.setJourney(journeysService.readById(journeyId));
        return ticketsModel;
    }

    @PatchMapping("/admin/tickets")
    public String update(@RequestParam int id,
                         @RequestParam String surname,
                         @RequestParam String name,
                         @RequestParam String phone,
                         @RequestParam String email,
                         @RequestParam int journeyId,
                         @RequestParam int seatNumber,
                         @RequestParam int stopNumberFrom,
                         @RequestParam int stopNumberTo,
                         @RequestParam int price) {
        ticketsService.update(
                id,
                surname,
                name,
                phone,
                email,
                journeyId,
                seatNumber,
                stopNumberFrom,
                stopNumberTo,
                price
        );
        return "redirect:/admin/tickets?journeyId=" + journeyId;
    }

    @DeleteMapping("/admin/tickets")
    public String delete(@RequestParam int id,
                         @RequestParam int journeyId) {
        ticketsService.delete(id);
        return "redirect:/admin/tickets?journeyId=" + journeyId;
    }
}
