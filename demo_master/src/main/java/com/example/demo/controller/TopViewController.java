package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopViewController {

    @GetMapping("/")
    String home() {
    	
    	// 戻り値はhome.html(拡張子はつけない)
    	return "home";
    }
    
}
