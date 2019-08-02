package com.amituofo.spring.restfulwebservices.controllers;

import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
  }
}
