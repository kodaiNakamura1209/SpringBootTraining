package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LoginDto;
import com.example.demo.exception.ValidatedException;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
    @GetMapping("/login/top")
    public String loginTop(Model model) {
    	
    	// ログイン情報格納用のオブジェクトを設定
    	model.addAttribute("loginInfo", new LoginDto());
    	
    	return "login";
    }
    
    @PostMapping("/login/loginDo")
    public String loginDo(Model model, @Validated @ModelAttribute LoginDto loginDto,  BindingResult bindingResult) {
    	
    	// エラーチェック
    	if (bindingResult.hasErrors()) {
    		System.out.println("!!!! パターンエラー発生 !!!!");
    		System.out.println(bindingResult.getFieldError().getDefaultMessage());
    		throw new ValidatedException("E_001", bindingResult.getFieldError().getDefaultMessage());
    	}
    	
    	// ログインユーザーの情報を取得
    	LoginDto result = service.loginUserSelect(loginDto);
    	
    	// ユーザーIDが空の場合はログイン失敗のため、前のページに戻る
    	if("".equals(loginDto.getUserId())) {
        	// ログイン情報格納用のオブジェクトを設定
        	model.addAttribute("loginInfo", new LoginDto());
    		return "login";
    	}
    	
    	// 情報が格納されている場合は、マイページへ遷移
    	model.addAttribute("mypageInfo", result);
    	return "myPage";
    }
}
