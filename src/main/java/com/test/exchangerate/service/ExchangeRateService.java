package com.test.exchangerate.service;

import com.test.exchangerate.controller.dto.RequestAmountReceivedDto;
import com.test.exchangerate.controller.dto.ResponseAmountReceivedDto;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate getExchangeRate(RecipientCountry recipientCountry) {
        return exchangeRateRepository.findByRecipientCountry(recipientCountry);
    }

    public ResponseAmountReceivedDto amountReceived(RequestAmountReceivedDto exchangeRateDto) {

        ExchangeRate findExchangeRete = exchangeRateRepository
                .findByRecipientCountry(exchangeRateDto.getRecipientCountry());

        String amountReceived = findExchangeRete.calculateAmountReceived(exchangeRateDto.getRemittance());

        return ResponseAmountReceivedDto.of(amountReceived, findExchangeRete.getRecipientCountry());
    }

}
