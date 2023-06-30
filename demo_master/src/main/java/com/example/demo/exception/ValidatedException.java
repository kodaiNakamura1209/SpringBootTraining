package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

public class ValidatedException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String errorCode;
	
    public ValidatedException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
