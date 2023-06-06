package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Size(min = 8,max = 8,message = "ユーザーIDは8文字で入力してください")
	private String userId;
	
	@NotBlank(message = "パスワードを入力してください")
	@Size(min = 8,max = 18,message = "パスワードは8～18文字で入力してください")
	private String userPassword;
	
	private String userName;
}
