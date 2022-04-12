package com.test.exchangerate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum RecipientCountry {
    KRW("KRW"),
    JPY("JPY"),
    PHP("PHP");

    private String country;

    public static String recipientCountries() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(values()).forEach(e -> builder.append(e).append(","));
        return builder.toString();
    }
}
