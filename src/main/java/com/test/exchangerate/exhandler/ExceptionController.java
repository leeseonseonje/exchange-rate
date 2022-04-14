package com.test.exchangerate.exhandler;

import com.test.exchangerate.controller.ExchangeRateController;
import com.test.exchangerate.exhandler.exception.NoRecipientCountryException;
import com.test.exchangerate.exhandler.exception.NotValid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice(assignableTypes = ExchangeRateController.class)
public class ExceptionController {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NoRecipientCountryException.class)
    public String noRecipientCountryExceptionHandler(NoRecipientCountryException e) {
        return e.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<NotValid> notValidExceptionHandler(MethodArgumentNotValidException e) {

        return e.getBindingResult().getAllErrors()
                .stream().map(ex -> new NotValid(((FieldError) ex).getField(), ex.getDefaultMessage())).collect(toList());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String parseErrorHandler(HttpMessageNotReadableException e) {
        return "ok";
    }
}
