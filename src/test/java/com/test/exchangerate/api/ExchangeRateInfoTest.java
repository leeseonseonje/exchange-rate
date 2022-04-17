package com.test.exchangerate.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ExchangeRateInfoTest {

    @Autowired
    ExchangeRateInfo exchangeRateInfo;

    @Test
    public void getExchangeRate() {
        exchangeRateInfo.exchangeRateCall();
    }
}