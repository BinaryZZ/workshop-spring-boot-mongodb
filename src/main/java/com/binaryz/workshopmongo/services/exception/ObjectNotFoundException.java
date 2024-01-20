package com.binaryz.workshopmongo.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long SerialVersionUID = 1L;

    public  ObjectNotFoundException(String msg) { // Constructor to override the msg
        super(msg);
    }
}
