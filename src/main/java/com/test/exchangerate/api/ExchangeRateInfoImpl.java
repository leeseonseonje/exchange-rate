package com.test.exchangerate.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExchangeRateInfoImpl implements ExchangeRateInfo {

    private final ExchangeRateRepository exchangeRateRepository;

    @Value("${exchange.rate.api.key}")
    private String accessKey;

    @Override
    @PostConstruct
    public void getExchangeRate() {

        String response = apiCall();

        exchangeRateRepository.saveExchangeRateInfo(exchangeRateInfoMapping(response));

        log.info("API CALL SUCCESS");
    }

    private Map<String, ExchangeRate> exchangeRateInfoMapping(String response) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, ExchangeRate> map = new HashMap<>();
        try {
            ExchangeRateDto dto = mapper.readValue(response, ExchangeRateDto.class);
            map = dto.getQuotes().keySet().stream()
                    .collect(toMap(e -> e.substring(3),
                            e -> ExchangeRate.of(e.substring(3), dto.getQuotes().get(e))));
            return map;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

    private String apiCall() {

        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(new ExchangeRateApiUrl(accessKey).toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
