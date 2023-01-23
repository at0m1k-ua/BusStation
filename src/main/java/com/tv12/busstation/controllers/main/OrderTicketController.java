package com.tv12.busstation.controllers.main;

import com.tv12.busstation.models.OrderTicketModel;
import com.tv12.busstation.services.JourneySeatDAO;
import com.tv12.busstation.services.TripDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderTicketController {

    private final TripDAO tripDAO;
    private final JourneySeatDAO journeySeatDAO;

    public OrderTicketController(TripDAO tripDAO,
                                 JourneySeatDAO journeySeatDAO) {
        this.tripDAO = tripDAO;
        this.journeySeatDAO = journeySeatDAO;
    }

    @PostMapping("/orderTicket")
    public ModelAndView orderTicket(@RequestParam int journeyId,
                                    @RequestParam int stopIdFrom,
                                    @RequestParam int stopIdTo) {
        OrderTicketModel orderTicketModel = new OrderTicketModel();
        orderTicketModel.setPrice(tripDAO.getPrice(journeyId, stopIdFrom, stopIdTo));
        orderTicketModel.setAvailableSeats(journeySeatDAO.getAvailableSeats(journeyId, stopIdFrom, stopIdTo));
        orderTicketModel.setJourneyId(journeyId);
        orderTicketModel.setStopIdFrom(stopIdFrom);
        orderTicketModel.setStopIdTo(stopIdTo);
        return orderTicketModel;
    }
}
