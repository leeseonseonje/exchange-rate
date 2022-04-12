package com.test.exchangerate.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeRateInfoImpl implements ExchangeRateInfo {

    @Value("${exchange.rate.api.key}")
    private String accessKey;

    @Override
    public void getExchangeRate() throws ParseException {
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(new ExchangeRateApiUrl(accessKey).toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        JSONParser jsonParser = new JSONParser();
        Object parse = jsonParser.parse(response);
        JSONObject jsonObject = (JSONObject) parse;

        System.out.println(jsonObject.get("quotes"));

    }
}
