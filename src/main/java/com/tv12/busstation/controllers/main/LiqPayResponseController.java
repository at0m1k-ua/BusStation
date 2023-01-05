package com.tv12.busstation.controllers.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tv12.busstation.entities.Driver;
import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.entities.Ticket;
import com.tv12.busstation.services.*;
import com.tv12.busstation.ui.UiDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Base64;
import java.util.Map;

@Controller
public class LiqPayResponseController {
    private final PendingTicketStorage pendingTicketStorage;
    private final TicketsService ticketsService;
    private final JourneyStopsService journeyStopsService;
    private final TemplateEngine templateEngine;
    private final EmailSender emailSender;

    public LiqPayResponseController(PendingTicketStorage pendingTicketStorage,
                                    TicketsService ticketsService,
                                    JourneyStopsService journeyStopsService,
                                    TemplateEngine templateEngine,
                                    EmailSender emailSender) {
        this.pendingTicketStorage = pendingTicketStorage;
        this.ticketsService = ticketsService;
        this.journeyStopsService = journeyStopsService;
        this.templateEngine = templateEngine;
        this.emailSender = emailSender;
    }

    @PostMapping("/liqPayResponse")
    public String getLiqPayResponse(@RequestParam String signature,
                                    @RequestParam String data) throws JsonProcessingException {
        String base64DecodedData = new String(Base64.getDecoder().decode(data));
        Map<String, String> dataMap = new ObjectMapper().readValue(base64DecodedData, Map.class);

        String alias = dataMap.get("order_id");
        Ticket ticket = pendingTicketStorage.getTicket(alias);

        ticketsService.create(
                ticket.getSurname(),
                ticket.getName(),
                ticket.getPhone(),
                ticket.getEmail(),
                ticket.getJourney().getId(),
                ticket.getSeatNumber(),
                ticket.getFrom().getId(),
                ticket.getTo().getId(),
                ticket.getPrice()
        );

        JourneyStop from = journeyStopsService.getByIds(ticket.getJourney().getId(), ticket.getFrom().getId());
        JourneyStop to = journeyStopsService.getByIds(ticket.getJourney().getId(), ticket.getTo().getId());
        Driver driver = ticket.getJourney().getDriver();

        Context context = new Context();
        context.setVariable("ticketId", ticket.getId());
        context.setVariable("passengerFullName", ticket.getName() + " " + ticket.getSurname());
        context.setVariable("price", ticket.getPrice());
        context.setVariable("fromCityName", ticket.getFrom().getCity().getName());
        context.setVariable("toCityName", ticket.getTo().getCity().getName());
        context.setVariable("fromTimestamp", new UiDateTime(from.getTimestamp()));
        context.setVariable("toTimestamp", new UiDateTime(to.getTimestamp()));
        context.setVariable("seatNumber", ticket.getSeatNumber());
        context.setVariable("driverFullName", driver.toString());
        context.setVariable("driverId", driver.getId());
        context.setVariable("driverPhone", driver.getPhone());
        context.setVariable("driverEmail", driver.getEmail());

        String html = templateEngine.process("ticket", context);
        emailSender.sendHtml(html, ticket.getEmail());

        return "redirect:/";
    }
}
