package com.test.exchangerate.api.dto;

import com.test.exchangerate.domain.RecipientCountry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExchangeRateApiDto implements Serializable {

    private String success;
    private String terms;
    private String privacy;
    private String timestamp;
    private String source;
    private Map<String, BigDecimal> quotes = new HashMap<>();
}
