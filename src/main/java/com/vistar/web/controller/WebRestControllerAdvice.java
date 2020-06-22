package com.vistar.web.controller;

import com.vistar.exception.EntityNotFoundException;
import com.vistar.exception.ValidationException;
import com.vistar.web.dto.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest controllers exception interceptor.
 */
@RestControllerAdvice
@Slf4j
public class WebRestControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFound(final EntityNotFoundException ex) {
        log.debug(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorMessage> wrongData(final ValidationException ex) {
        log.debug(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(ex.getMessage()));
    }
}
