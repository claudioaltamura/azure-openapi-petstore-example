package de.claudioaltamura.azure.openapi.petstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PetStoreGlobalControllerExceptionHandler {

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<de.claudioaltamura.azure.openapi.petstore.model.Error> handleClientError(
            RuntimeException ex) {
        var error = new de.claudioaltamura.azure.openapi.petstore.model.Error(-1, "this shouldn't happened: '" + ex.getMessage() + "'.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
