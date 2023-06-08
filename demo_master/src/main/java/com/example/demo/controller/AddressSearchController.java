package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.AddressSearchDto;
import com.example.demo.service.AddressSearchService;

@Controller
public class AddressSearchController {
	
	@Autowired
	AddressSearchService service;
	
	@GetMapping("/addressSearch")
	public String AddressSearchView(Model model) {
		model.addAttribute("addressSearchDto",new AddressSearchDto());
		return "addressSearch";
	}
	
	@PostMapping("/addressSearch/SearchDo")
	public String AddressSearchDo(Model model, @ModelAttribute AddressSearchDto addressSearchDto) {
		
		AddressSearchDto result = service.addressSearchApiCall(addressSearchDto);
		
		//ログ
		System.out.println(result.getResult().getResults().get(0).getZipcode());
		System.out.println(result.getResult().getResults().get(0).getAddress1());
		System.out.println(result.getResult().getResults().get(0).getAddress2());
		System.out.println(result.getResult().getResults().get(0).getAddress3());
		
		model.addAttribute("addressSearchDto",result);
		
		return "addressSearch";
	}
}
