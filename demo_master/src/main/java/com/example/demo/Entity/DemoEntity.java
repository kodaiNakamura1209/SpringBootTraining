package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor         // 全部入りのコンストラクタを作る
public class DemoEntity {
	
	public DemoEntity(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
    String userId;

    String userPassword;

    String userName;
}
