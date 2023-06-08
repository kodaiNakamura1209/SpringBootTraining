package com.example.demo.dataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author natur
 * 
 * DB接続用のpropertyを取得するクラス
 */
@ConfigurationProperties(prefix="spring.datasource")
@Component
@Data
public class DbAccessDataSource {
	
	/** URL */
	private String url;
	
	/** ユーザー名 */
	private String username;
	
	/** パスワード */
	private String password;
}
