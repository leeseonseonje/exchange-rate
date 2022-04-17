package com.test.exchangerate.controller;

import com.test.exchangerate.controller.dto.ExchangeRateDto;
import com.test.exchangerate.controller.dto.ResponseAmountReceivedDto;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/{recipientCountry}")
    public ExchangeRateDto exchangeRateInfo(@PathVariable String recipientCountry) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(RecipientCountry.from(recipientCountry));
        return new ExchangeRateDto(exchangeRate.getRecipientCountry(), exchangeRate.getExchangeRate());
    }

    @GetMapping("/{recipientCountry}/{remittance}")
    public ResponseAmountReceivedDto amountReceived(@PathVariable String recipientCountry, @PathVariable BigDecimal remittance) {
        return exchangeRateService.amountReceived(recipientCountry, remittance);
    }
}
