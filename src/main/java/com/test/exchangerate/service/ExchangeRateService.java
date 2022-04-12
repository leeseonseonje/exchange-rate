package com.test.exchangerate.service;

import com.test.exchangerate.api.ExchangeRateInfo;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateInfo exchangeRateInfo;

    public void getExchangeRate() throws ParseException {
        exchangeRateInfo.getExchangeRate();
    }

}
