package com.tv12.busstation.models.admin;

import com.tv12.busstation.entities.Journey;
import com.tv12.busstation.entities.Ticket;
import org.springframework.web.servlet.ModelAndView;

public class TicketsModel extends ModelAndView {

    public TicketsModel() {
        super("/admin/tickets");
    }

    public void setTickets(Iterable<Ticket> tickets) {
        addObject("tickets", tickets);
    }
    public void setJourney(Journey journey) {
        addObject("journey", journey);
    }
}
