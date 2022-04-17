package com.test.exchangerate.controller;

import com.test.exchangerate.api.ExchangeRateInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExchangeRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getExchangeRate() throws Exception {
        this.mockMvc.perform(get("/exchange-rate/KRW").contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void amountReceived() throws Exception {
        this.mockMvc.perform(get("/exchange-rate/KRW/100").contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void illegalRecipientCountry() throws Exception {
        this.mockMvc.perform(get("/exchange-rate/ERROR").contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void illegalRemittance() throws Exception {
        this.mockMvc.perform(get("/exchange-rate/KRW/10001").contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}