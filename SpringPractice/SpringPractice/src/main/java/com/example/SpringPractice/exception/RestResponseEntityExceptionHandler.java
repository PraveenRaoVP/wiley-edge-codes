package com.example.SpringPractice.exception;

import com.example.SpringPractice.response.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorMessage> authorNotFoundException(AuthorNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> bookNotFoundException(BookNotFoundException ex, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
