package com.test.exchangerate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.repository.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

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

        ExchangeRate exchangeRate = initData();

        assertThat(exchangeRate.getRecipientCountry()).isEqualTo(RecipientCountry.KRW);
    }

    @Test
    public void amountReceived() {

        ExchangeRate exchangeRate = initData();

        exchangeRate.calculateAmountReceived(BigDecimal.valueOf(100));

    }

    private ExchangeRate initData() {
        exchangeRateInfo.getExchangeRate();

        return exchangeRateRepository.findByRecipientCountry(RecipientCountry.KRW);
    }

}