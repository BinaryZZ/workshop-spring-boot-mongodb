package com.binaryz.workshopmongo.resources.exception;

import com.binaryz.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Deal with possible errors on requests
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // Set to do this exception instead of mentioned one
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){ // treatment of ObjectNotFoundException on requests

        HttpStatus status = HttpStatus.NOT_FOUND; // Set HTTP status as not found
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI()); /*
        Instantiate a new Standard Error */
        return ResponseEntity.status(status).body(err);
    }
}
