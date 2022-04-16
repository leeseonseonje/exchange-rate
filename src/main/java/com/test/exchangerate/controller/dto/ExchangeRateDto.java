package com.test.exchangerate.controller.dto;

import com.test.exchangerate.domain.RecipientCountry;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ExchangeRateDto {

    private RecipientCountry recipientCountry;

    private BigDecimal exchangeRate;
}
