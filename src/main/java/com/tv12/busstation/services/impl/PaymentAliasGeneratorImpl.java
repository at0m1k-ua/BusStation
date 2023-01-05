package com.tv12.busstation.services.impl;

import com.tv12.busstation.services.PaymentAliasGenerator;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Controller
public class PaymentAliasGeneratorImpl implements PaymentAliasGenerator {

    private static final int SIZE = 64;

    private static final String allowedSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

    @Override
    public String getAlias() {
        StringBuilder stringBuilder = new StringBuilder(SIZE);

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int index = random.nextInt(allowedSymbols.length());
            char character = allowedSymbols.charAt(index);
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
