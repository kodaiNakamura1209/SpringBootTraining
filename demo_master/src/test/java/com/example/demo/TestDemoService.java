package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.DemoDto;
import com.example.demo.service.DemoService;

@SpringBootTest
public class TestDemoService {

	@Autowired
	DemoService service;
	
	@Test
	public void test001() {
		assertEquals(service.hello(), "hello");
	}
	
	@Test
	public void test002() {
		
		DemoDto dto = new DemoDto();
		dto.setUserId("");
		dto = service.getData(dto);
		
		assertEquals(dto.getUserId(), "");
		assertEquals(dto.getUserName(), "");
	}
}
