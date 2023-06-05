package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.DemoEntity;
import com.example.demo.dto.LoginDto;
import com.example.demo.repository.DemoRepository;

@Service
public class LoginService {
	
    @Autowired
    DemoRepository repository;
	
	public LoginDto loginUserSelect(LoginDto loginDto) {
		
		// ユーザ情報をセレクト
		DemoEntity entity = repository.selectUserInfo(convertDtoToEntity(loginDto));

		// userid,usernameの情報をDTOに設定
		loginDto.setUserId(entity.getUserId());
		loginDto.setUserName(entity.getUserName());
		
		return loginDto;
	}

    // Dto → Entityに情報を詰める
    private DemoEntity convertDtoToEntity(LoginDto dto){
        DemoEntity entity = new DemoEntity(dto.getUserId(), dto.getUserPassword(), "");
        return entity;
    }
}
