package com.example.demo.dataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="spring.datasource")
@Component
@Data
public class DbAccessDataSource {
	
	private String url;
	
	private String username;
	
	private String password;
}
