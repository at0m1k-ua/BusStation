package com.tv12.busstation.controllers.main;

import com.liqpay.LiqPay;
import com.tv12.busstation.LiqPayProperties;
import com.tv12.busstation.entities.JourneyStop;
import com.tv12.busstation.entities.Ticket;
import com.tv12.busstation.models.PaymentModel;
import com.tv12.busstation.services.JourneyStopDAO;
import com.tv12.busstation.services.PaymentAliasGenerator;
import com.tv12.busstation.services.PendingTicketStorage;
import com.tv12.busstation.services.TicketDAO;
import com.tv12.busstation.ui.UiDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PaymentController {

    private final JourneyStopDAO journeyStopDAO;
    private final TicketDAO ticketDAO;
    private final PendingTicketStorage pendingTicketStorage;
    private final PaymentAliasGenerator paymentAliasGenerator;

    public PaymentController(JourneyStopDAO journeyStopDAO,
                             TicketDAO ticketDAO,
                             PendingTicketStorage pendingTicketStorage,
                             PaymentAliasGenerator paymentAliasGenerator) {
        this.journeyStopDAO = journeyStopDAO;
        this.ticketDAO = ticketDAO;
        this.pendingTicketStorage = pendingTicketStorage;
        this.paymentAliasGenerator = paymentAliasGenerator;
    }

    @PostMapping("/payment")
    public PaymentModel payment(@RequestParam int journeyId,
                                @RequestParam int stopIdFrom,
                                @RequestParam int stopIdTo,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam int seatNumber,
                                @RequestParam String email,
                                @RequestParam String phone) {
        String alias = paymentAliasGenerator.getAlias();

        Ticket ticket = ticketDAO.createInPendingStorage(
                alias,
                surname,
                name,
                phone,
                email,
                journeyId,
                seatNumber,
                stopIdFrom,
                stopIdTo
        );

        JourneyStop from = journeyStopDAO.getByIds(journeyId, stopIdFrom);
        JourneyStop to = journeyStopDAO.getByIds(journeyId, stopIdTo);

        UiDateTime departureDateTime = new UiDateTime(from.getTimestamp());
        UiDateTime arrivalDateTime = new UiDateTime(to.getTimestamp());

        String description =
                "Квиток на автобус, " +
                name + " " + surname + ", " +
                from.getCityName() + " - " + to.getCityName() + ", " +
                departureDateTime.getStringDate();

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setFromCityName(from.getCityName());
        paymentModel.setToCityName(to.getCityName());
        paymentModel.setFullName(name + " " + surname);
        paymentModel.setEmail(email);
        paymentModel.setPhone(phone);
        paymentModel.setSeatNumber(seatNumber);
        paymentModel.setDepartureDateTime(departureDateTime.toString());
        paymentModel.setArrivalDateTime(arrivalDateTime.toString());
        paymentModel.setPaymentButtonHtml(generatePaymentButton(
                alias,
                ticket.getPrice(),
                description
        ));

        return paymentModel;
    }

    private String generatePaymentButton(String alias, int price, String description) {
        Map<String, String> params = new HashMap<>();
        params.put("action", "pay");
        params.put("amount", String.valueOf(price));
        params.put("currency", "UAH");
        params.put("description", description);
        params.put("order_id", alias);
        params.put("version", LiqPay.API_VERSION);
        params.put("result_url", LiqPayProperties.SERVER_URL);
        params.put("server_url", LiqPayProperties.SERVER_URL + "/liqPayResponse");
        LiqPay liqpay = new LiqPay(LiqPayProperties.PUBLIC_KEY, LiqPayProperties.PRIVATE_KEY);
        return liqpay.cnb_form(params);
    }
}
