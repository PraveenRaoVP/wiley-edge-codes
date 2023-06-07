package com.example.appointmentauthor.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends Exception {

}
