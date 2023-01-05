package com.tv12.busstation.models;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class OrderTicketModel extends ModelAndView {
    public OrderTicketModel() {
        super("order_ticket");
    }

    public void setPrice(int price) {
        addObject("price", price);
    }

    public void setAvailableSeats(List<Integer> availableSeats) {
        addObject("availableSeats", availableSeats);
    }

    public void setJourneyId(int journeyId) {
        addObject("journeyId", journeyId);
    }

    public void setStopIdFrom(int stopIdFrom) {
        addObject("stopIdFrom", stopIdFrom);
    }

    public void setStopIdTo(int stopIdTo) {
        addObject("stopIdTo", stopIdTo);
    }
}
