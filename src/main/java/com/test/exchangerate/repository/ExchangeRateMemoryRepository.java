package com.test.exchangerate.repository;

import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ExchangeRateMemoryRepository implements ExchangeRateRepository {

    private static final Map<String, ExchangeRate> cache = new ConcurrentHashMap<>();

    public void saveExchangeRateInfo(Map<String, ExchangeRate> map) {
        cache.putAll(map);
    }

    public ExchangeRate findByRecipientCountry(String recipientCountry) {
        return cache.get(recipientCountry);
    }
}
