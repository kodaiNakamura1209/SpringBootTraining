package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.error.ApiError;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler({ValidatedException.class})
    public ApiError handleValidatedException(ValidatedException ex) {
        // リクエストのBodyのセット
        ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
        return apiError;
    }
}
