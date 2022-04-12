package com.test.exchangerate.api;

import com.test.exchangerate.repository.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExchangeRateInfoImplTest {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Test
    void nullTest() {
        exchangeRateRepository.saveExchangeRateInfo(new HashMap<>());
    }
}