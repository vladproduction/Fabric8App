package com.vladproduction.fabric8app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductIsNotFoundException extends RuntimeException{

    public ProductIsNotFoundException(String message) {
        super(message);
    }
}
