package com.test.exchangerate.exhandler;

import com.test.exchangerate.controller.ExchangeRateController;
import com.test.exchangerate.exhandler.exception.IllegalRecipientCountryException;
import com.test.exchangerate.exhandler.exception.IllegalRemittanceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice(assignableTypes = ExchangeRateController.class)
public class ExceptionController {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalRecipientCountryException.class)
    public String noRecipientCountryExceptionHandler(IllegalRecipientCountryException e) {
        log.error("IllegalRecipientCountryException = {}", e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalRemittanceException.class)
    public String illegalArgumentExceptionHandler(IllegalRemittanceException e) {
        log.error("IllegalRemittanceException = {}", e.getMessage());
        return e.getMessage();
    }
}
