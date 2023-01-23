package com.tv12.busstation.controllers.admin;

import com.tv12.busstation.models.admin.TicketsModel;
import com.tv12.busstation.services.JourneyDAO;
import com.tv12.busstation.services.TicketDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TicketsController {

    private final TicketDAO ticketDAO;
    private final JourneyDAO journeyDAO;

    public TicketsController(TicketDAO ticketDAO,
                             JourneyDAO journeyDAO){
        this.ticketDAO = ticketDAO;
        this.journeyDAO = journeyDAO;
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
        ticketDAO.create(
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
        ticketsModel.setTickets(ticketDAO.getByJourneyId(journeyId));
        ticketsModel.setJourney(journeyDAO.readById(journeyId));
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
        ticketDAO.update(
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
        ticketDAO.delete(id);
        return "redirect:/admin/tickets?journeyId=" + journeyId;
    }
}
