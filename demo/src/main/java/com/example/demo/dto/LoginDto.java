package com.example.demo.dto;

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

	@javax.validation.constraints.NotBlank(message = "ユーザーIDを入力してください")
	@javax.validation.constraints.Size(min = 8,max = 8,message = "ユーザーIDは8文字で入力してください")
	private String userId;
	
	@javax.validation.constraints.NotBlank(message = "パスワードを入力してください")
	@javax.validation.constraints.Size(min = 8,max = 18,message = "パスワードは8～18文字で入力してください")
	private String userPassword;
	
	private String userName;
}
