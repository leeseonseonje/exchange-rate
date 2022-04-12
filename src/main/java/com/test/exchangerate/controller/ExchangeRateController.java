package com.test.exchangerate.controller;

import com.test.exchangerate.api.ExchangeRateInfo;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateInfo exchangeRateInfo;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/exchange-rate")
    public String test() throws ParseException {
        exchangeRateInfo.getExchangeRate();

        return "ok";
    }
}
