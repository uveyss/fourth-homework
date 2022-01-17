package com.example.fourthworksheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DebitNotFoundException extends RuntimeException{

    public DebitNotFoundException(String message) {
        super(message);
    }
}
