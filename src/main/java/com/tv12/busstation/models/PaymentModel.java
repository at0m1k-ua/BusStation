package com.tv12.busstation.models;

import org.springframework.web.servlet.ModelAndView;

public class PaymentModel extends ModelAndView {
    public PaymentModel() {
        super("/payment");
    }

    public void setFromCityName(String value) {
        addObject("fromCityName", value);
    }

    public void setToCityName(String value) {
        addObject("toCityName", value);
    }

    public void setFullName(String value) {
        addObject("fullName", value);
    }

    public void setEmail(String value) {
        addObject("email", value);
    }

    public void setPhone(String value) {
        addObject("phone", value);
    }

    public void setSeatNumber(int value) {
        addObject("seatNumber", value);
    }

    public void setDepartureDateTime(String value) {
        addObject("departureDateTime", value);
    }

    public void setArrivalDateTime(String value) {
        addObject("arrivalDateTime", value);
    }

    public void setPaymentButtonHtml(String value) {
        addObject("paymentButtonHtml", value);
    }
}
