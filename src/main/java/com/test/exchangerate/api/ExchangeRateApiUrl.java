package com.test.exchangerate.api;

import com.test.exchangerate.domain.Currency;
import com.test.exchangerate.domain.RecipientCountry;

public class ExchangeRateApiUrl {

    private String url;
    private String accessKey;
    private String currency;
    private String recipientCountry;

    public ExchangeRateApiUrl(String accessKey) {
        this.url = "http://api.currencylayer.com/live?access_key=";
        this.accessKey = accessKey;
        this.currency = "&source=" + Currency.USD;
        this.recipientCountry = "&currencies=" + RecipientCountry.recipientCountries();
    }

    @Override
    public String toString() {
        return url + accessKey + currency + recipientCountry;
    }
}
