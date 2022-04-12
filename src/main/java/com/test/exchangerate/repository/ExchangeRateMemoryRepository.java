package com.test.exchangerate.repository;

import com.test.exchangerate.domain.ExchangeRate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ExchangeRateMemoryRepository implements ExchangeRateRepository {

    private static final Map<String, ExchangeRate> cache = new ConcurrentHashMap<>();

    @Override
    public void saveExchangeRateInfo(Map<String, ExchangeRate> map) {
        cache.putAll(map);
    }

    @Override
    public ExchangeRate findByRecipientCountry(String recipientCountry) {
        return cache.get(recipientCountry);
    }
}
