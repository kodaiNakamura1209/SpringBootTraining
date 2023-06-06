package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

	@NotBlank(message = "ユーザーIDを入力してください")
	private String userId;
	
	@NotBlank(message = "パスワードを入力してください")
	private String userPassword;
	
	private String userName;
}
