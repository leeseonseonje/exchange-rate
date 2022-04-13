package com.test.exchangerate.exhandler;

import com.test.exchangerate.controller.ExchangeRateController;
import com.test.exchangerate.exhandler.exception.NotValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(IllegalArgumentException e) {
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<NotValid>> notValidExceptionHandler(MethodArgumentNotValidException e) {

        List<NotValid> result = e.getBindingResult().getAllErrors()
                .stream().map(ex -> new NotValid(((FieldError) ex).getField(), ex.getDefaultMessage())).collect(toList());
        return new ResponseEntity<>(result, BAD_REQUEST);
    }
}
