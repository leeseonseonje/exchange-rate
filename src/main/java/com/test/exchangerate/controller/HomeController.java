package com.test.exchangerate.controller;

import com.test.exchangerate.domain.ExchangeRate;
import com.test.exchangerate.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.util.stream.Collectors.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ExchangeRateRepository exchangeRateRepository;

    @GetMapping()
    public String home(Model model) {

        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();

        model.addAttribute("counties", exchangeRates);
        return "home";
    }
}
