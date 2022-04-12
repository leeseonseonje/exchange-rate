package com.test.exchangerate.controller;

import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/exchange-rate")
    public String exchangeRateInfo(@RequestParam String recipientCountry) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(recipientCountry);
        return exchangeRate.getRecipientCountry() + exchangeRate.getExchangeRate();
    }
}
