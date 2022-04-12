package com.test.exchangerate.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRate {

    private String recipientCountry;
    private BigDecimal exchangeRate;

    @Builder
    private ExchangeRate(String recipientCountry, BigDecimal exchangeRate) {
        this.recipientCountry = recipientCountry;
        this.exchangeRate = exchangeRate;
    }

    @Builder
    public static ExchangeRate of(String recipientCountry, BigDecimal exchangeRate) {
        return ExchangeRate.builder()
                .recipientCountry(recipientCountry)
                .exchangeRate(exchangeRate)
                .build();
    }
}
