package com.test.exchangerate.repository;

import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;

import java.util.List;

public interface ExchangeRateRepository {

    void saveExchangeRateInfo(List<ExchangeRate> map);

    ExchangeRate findByRecipientCountry(RecipientCountry recipientCountry);
}
