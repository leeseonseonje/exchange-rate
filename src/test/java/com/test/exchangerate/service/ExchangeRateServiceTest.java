package com.test.exchangerate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.repository.ExchangeRateRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ExchangeRateServiceTest {

    @Autowired
    ExchangeRateInfo exchangeRateInfo;

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Test
    public void getExchangeRate() throws JsonProcessingException {
        exchangeRateInfo.getExchangeRate();
    }

    @Test
    public void findByRecipientCountry() {

        exchangeRateInfo.getExchangeRate();

        ExchangeRate krw = exchangeRateRepository.findByRecipientCountry("KRW");

        assertThat(krw.getRecipientCountry()).isEqualTo("KRW");
    }

}