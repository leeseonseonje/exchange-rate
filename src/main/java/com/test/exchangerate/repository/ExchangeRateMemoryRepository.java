package com.test.exchangerate.repository;

import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.*;

@Repository
public class ExchangeRateMemoryRepository implements ExchangeRateRepository {

    private static final Map<RecipientCountry, ExchangeRate> memory = new ConcurrentHashMap<>();

    @Override
    public void saveExchangeRateInfo(List<ExchangeRate> list) {
        for (ExchangeRate exchangeRate : list) {
            System.out.println(exchangeRate.getRecipientCountry());
        }
        memory.putAll(listToMap(list));
    }

    private Map<RecipientCountry, ExchangeRate> listToMap(List<ExchangeRate> list) {
        return list.stream()
                .collect(toMap(ExchangeRate::getRecipientCountry, e -> e));
    }

    @Override
    public ExchangeRate findByRecipientCountry(RecipientCountry recipientCountry) {
        return memory.get(recipientCountry);
    }

    @Override
    public List<ExchangeRate> findAll() {
        memory.keySet().forEach(e -> System.out.println(e + " : " + memory.get(e)));
        return new ArrayList<>(memory.values());
    }
}
