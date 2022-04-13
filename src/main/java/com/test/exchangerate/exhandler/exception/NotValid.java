package com.test.exchangerate.exhandler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotValid {

    private String errorValue;
    private String errorMessage;
}
