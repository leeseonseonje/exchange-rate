package com.test.exchangerate.repository;

import com.test.exchangerate.domain.ExchangeRate;

import java.util.Map;

public interface ExchangeRateRepository {

    void saveExchangeRateInfo(Map<String, ExchangeRate> map);

    ExchangeRate findByRecipientCountry(String recipientCountry);
}
