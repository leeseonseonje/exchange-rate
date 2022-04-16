package com.test.exchangerate.exhandler;

import com.test.exchangerate.controller.ExchangeRateController;
import com.test.exchangerate.exhandler.exception.NoRecipientCountryException;
import com.test.exchangerate.exhandler.exception.NotValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice(assignableTypes = ExchangeRateController.class)
public class ExceptionController {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String typeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        return "지원하지 않는 국가입니다.";
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NoRecipientCountryException.class)
    public String noRecipientCountryExceptionHandler(NoRecipientCountryException e) {
        log.error(e.getMessage());
        return e.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<NotValid> notValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("NOT VALID");
        return e.getBindingResult().getAllErrors()
                .stream().map(ex -> new NotValid(((FieldError) ex).getField(), ex.getDefaultMessage())).collect(toList());
    }
}
