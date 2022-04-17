package com.test.exchangerate.service;

import com.test.exchangerate.controller.dto.ResponseAmountReceivedDto;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.exhandler.exception.IllegalRemittanceException;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate getExchangeRate(RecipientCountry recipientCountry) {
        return exchangeRateRepository.findByRecipientCountry(recipientCountry);
    }

    public ResponseAmountReceivedDto amountReceived(String recipientCountry, BigDecimal remittance) {

        checkedRemittance(remittance);

        ExchangeRate findExchangeRete = exchangeRateRepository
                .findByRecipientCountry(RecipientCountry.from(recipientCountry));

        String amountReceived = findExchangeRete.calculateAmountReceived(remittance);

        return ResponseAmountReceivedDto.of(amountReceived, findExchangeRete.getRecipientCountry());
    }

    private void checkedRemittance(BigDecimal remittance) {
        if (remittance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalRemittanceException("1달러 보다 낮은 금액은 송금할 수 없습니다.");
        } else if (remittance.compareTo(BigDecimal.valueOf(10000)) > 0) {
            throw new IllegalRemittanceException("10000달러 보다 높은 금액은 송금할 수 없습니다.");
        }
    }

}
