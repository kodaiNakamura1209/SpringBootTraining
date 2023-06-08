package com.example.demo.dto;

import com.example.demo.response.AddressSearchApiResultResponse;

import lombok.Data;

@Data
public class AddressSearchDto {
	
	/** 入力値 */
	private String inputZipCode;
	
	private AddressSearchApiResultResponse result;
}
