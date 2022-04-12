package com.test.exchangerate.service;

import com.test.exchangerate.api.ExchangeRateInfo;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate getExchangeRate(String recipientCountry) {
        return exchangeRateRepository.findByRecipientCountry(recipientCountry);
    }

}
