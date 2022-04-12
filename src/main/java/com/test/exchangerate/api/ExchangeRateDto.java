package com.test.exchangerate.api;

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
public class ExchangeRateDto implements Serializable {

    private String success;
    private String terms;
    private String privacy;
    private String timestamp;
    private String source;
    private Map<String, BigDecimal> quotes = new HashMap<>();

    @Override
    public String toString() {
        return "TestDto{" +
                "success='" + success + '\'' +
                ", terms='" + terms + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", source='" + source + '\'' +
                ", quotes='" + quotes + '\'' +
                '}';
    }
}
