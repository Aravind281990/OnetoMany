package com.example.OneToManyMappingGlobal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
	@ExceptionHandler(InvalidAuthorIdException.class)
    public ResponseEntity<String> handleException(InvalidAuthorIdException e) {
    	System.out.println("i am inside global exception"+e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    
}
