package com.test.exchangerate.repository;

import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ExchangeRateMemoryRepositoryTest {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    @Autowired
    ExchangeRateInfo exchangeRateInfo;

    @Test
    void findByRecipientCountry() {
        ExchangeRate findCountry = exchangeRateRepository.findByRecipientCountry(RecipientCountry.KRW);

        assertThat(findCountry.getRecipientCountry()).isEqualTo(RecipientCountry.KRW);
    }

    @Test
    void findAll() {
        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();

        assertThat(exchangeRates.size()).isEqualTo(3);
    }

}