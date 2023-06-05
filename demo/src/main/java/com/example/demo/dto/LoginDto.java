package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {

	@NotBlank(message = "{NotBlank.LoginDto.userId}")
	private String userId;
	
	@NotBlank(message = "{NotBlank.LoginDto.userPassword}")
	private String userPassword;
}
