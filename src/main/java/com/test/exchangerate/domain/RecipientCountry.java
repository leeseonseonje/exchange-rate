package com.test.exchangerate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonCreator
    public static RecipientCountry from(String recipientCountry) {
        try {
            return RecipientCountry.valueOf(recipientCountry.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("지원하지 않는 국가입니다.");
        }
    }


}
