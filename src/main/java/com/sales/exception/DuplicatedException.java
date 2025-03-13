package com.sales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DuplicatedException extends ResponseStatusException {
    public DuplicatedException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }
}
