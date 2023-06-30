package com.example.demo.service;

import com.example.demo.Entity.DemoEntity;
import com.example.demo.dto.DemoDto;
import com.example.demo.repository.DemoRepository;
import com.example.demo.request.JsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service・・・Serviceクラスに付与
// 　　　　　　　　DI可能(@Autowired可能)なコンポーネントとして扱う(DIコンテナに登録)
@Service
public class DemoService {

    @Autowired
    DemoRepository repository;

    public String hello (){
        return "hello";
    }

    public String good(){
        return "ばいばい";
    }

    public DemoDto getData(DemoDto dto){
        DemoEntity entity = repository.selectUserInfo(convertDtoToEntity(dto));
        dto.setUserName(entity.getUserName());
        return dto;
    }

    // Dto → Entityに情報を詰める
    private DemoEntity convertDtoToEntity(DemoDto dto){
        DemoEntity entity = new DemoEntity(dto.getUserId(), "");
        return entity;
    }
}
