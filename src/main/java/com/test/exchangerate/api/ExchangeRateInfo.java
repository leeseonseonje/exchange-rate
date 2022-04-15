package com.test.exchangerate.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.exchangerate.api.dto.ExchangeRateApiDto;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.domain.RecipientCountry;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

import static java.math.RoundingMode.*;
import static java.util.stream.Collectors.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExchangeRateInfo  {

    private final ExchangeRateRepository exchangeRateRepository;

    @Value("${exchange.rate.api.key}")
    private String accessKey;

//    @PostConstruct
//    @Scheduled(cron = "0 10 0 * * *", zone = "UTC")
    public void exchangeRateCall() {

        String response = apiCall();

        exchangeRateRepository.saveExchangeRateInfo(exchangeRateInfoMapping(response));

        log.info("API CALL SUCCESS");
    }

    private String apiCall() {

        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(new ExchangeRateApiUrl(accessKey).toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private List<ExchangeRate> exchangeRateInfoMapping(String response) {

        ExchangeRateApiDto dto = null;
        try {
            dto = new ObjectMapper().readValue(response, ExchangeRateApiDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return generateExchangeRates(Objects.requireNonNull(dto));
    }

    private List<ExchangeRate> generateExchangeRates(ExchangeRateApiDto dto) {
        return dto.getQuotes().keySet().stream()
                .map(e -> ExchangeRate.of(RecipientCountry.valueOf(e.substring(3)), dto.getQuotes().get(e).setScale(2, HALF_EVEN)))
                .collect(toList());
    }

}
