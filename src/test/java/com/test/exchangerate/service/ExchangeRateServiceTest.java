package com.test.exchangerate.service;

import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.RecipientCountry;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExchangeRateServiceTest {

    @Autowired
    ExchangeRateInfo exchangeRateInfo;

    @Test
    public void getExchangeRate() throws ParseException {
        exchangeRateInfo.getExchangeRate();
    }

    @Test
    public void test() {
        RecipientCountry.recipientCountries();
    }

}