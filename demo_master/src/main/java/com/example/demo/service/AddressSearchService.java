package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressSearchDto;
import com.example.demo.response.AddressSearchApiResultResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddressSearchService {
	
	@Value("${spring.addresssearchapiurl}")
	private String addressSearchApiUrl;
	String urll="https://zip-cloud.appspot.com/api/search?zipcode=%s";
	
	@Autowired
	ObjectMapper objectMapper;
	
	public AddressSearchDto addressSearchApiCall(AddressSearchDto dto) {
        try {
            // ObjectMapperでURLと受け取りクラスを指定
            java.net.URL url = new java.net.URL(String.format(urll,dto.getInputZipCode()));
            dto.setResult(objectMapper.readValue(url, AddressSearchApiResultResponse.class));
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e);
        }
        return dto;
	}
}
