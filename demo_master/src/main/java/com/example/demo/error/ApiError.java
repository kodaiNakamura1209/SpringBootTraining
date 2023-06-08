package com.example.demo.error;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
public class ApiError {
	private String errorCode;
	private String message;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	
	public ApiError(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
