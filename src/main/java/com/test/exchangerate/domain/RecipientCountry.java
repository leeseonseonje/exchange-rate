package com.test.exchangerate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.test.exchangerate.exhandler.exception.NoRecipientCountryException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum RecipientCountry {
    KRW("한국"),
    JPY("일본"),
    PHP("필리핀");

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
            throw new NoRecipientCountryException("지원하지 않는 국가입니다.");
        }
    }


}
