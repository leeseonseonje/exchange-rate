package com.test.exchangerate.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Builder
public class ExchangeRate {

    private RecipientCountry recipientCountry;
    private BigDecimal exchangeRate;

    private ExchangeRate(RecipientCountry recipientCountry, BigDecimal exchangeRate) {
        this.recipientCountry = recipientCountry;
        this.exchangeRate = exchangeRate;
    }

    public static ExchangeRate of(RecipientCountry recipientCountry, BigDecimal exchangeRate) {
        return ExchangeRate.builder()
                .recipientCountry(recipientCountry)
                .exchangeRate(exchangeRate)
                .build();
    }

    public String amountReceivedCalc(BigDecimal amount) {
        BigDecimal amountReceived = this.exchangeRate.multiply(amount);
        return receivedFormat(amountReceived);
    }

    private String receivedFormat(BigDecimal amountReceived) {
        return new DecimalFormat("###,###.00").format(amountReceived);
    }
}
