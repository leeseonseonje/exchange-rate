package com.test.exchangerate.api;

import com.test.exchangerate.repository.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
class ExchangeRateInfoImplTest {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Test
    void nullTest() {
        exchangeRateRepository.saveExchangeRateInfo(new ArrayList<>());
    }
}