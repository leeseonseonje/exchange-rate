package com.test.exchangerate.controller;

import com.test.exchangerate.controller.dto.ExchangeRateDto;
import com.test.exchangerate.controller.dto.RequestAmountReceivedDto;
import com.test.exchangerate.controller.dto.ResponseAmountReceivedDto;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("/{recipientCountry}")
    public ExchangeRateDto exchangeRateInfo(@PathVariable RecipientCountry recipientCountry) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(recipientCountry);
        return new ExchangeRateDto(exchangeRate.getRecipientCountry(), exchangeRate.getExchangeRate());
    }

    @PostMapping()
    public ResponseAmountReceivedDto amountReceived(@Valid @RequestBody RequestAmountReceivedDto request) {
        return exchangeRateService.amountReceived(request);
    }
}
