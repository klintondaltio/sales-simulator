package com.sales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handlerNotFoundException(NotFoundException ex){
        var errorResponse = new DefaultErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getReason());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<DefaultErrorMessage> handlerSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), "Integrity exception, one of the fields shoud be unique.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<DefaultErrorMessage> handlerBadRequestException(BadRequestException ex){
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<DefaultErrorMessage> handlerDuplicatedExceptionException(DuplicatedException ex){
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
