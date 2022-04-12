package com.test.exchangerate.api;

import com.test.exchangerate.domain.Currency;
import com.test.exchangerate.domain.RecipientCountry;

public class ExchangeRateApiUrl {

    private String url;
    private String accessKey;
    private String currency;
    private String recipientCountry;

    public ExchangeRateApiUrl(String accessKey) {
        this.url = "http://api.currencylayer.com/live";
        this.accessKey = accessKey;
        this.currency = Currency.USD.getCurrency();
        this.recipientCountry = RecipientCountry.recipientCountries();
    }

    @Override
    public String toString() {
        return url +
                "?access_key=" + accessKey +
                "&source=" + currency +
                "&currencies=" + recipientCountry;
    }
}
