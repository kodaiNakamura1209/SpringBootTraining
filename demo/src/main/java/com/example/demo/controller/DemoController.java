package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DemoDto;
import com.example.demo.exception.ValidatedException;
import com.example.demo.request.JsonRequest;
import com.example.demo.service.DemoService;


//Controllerクラス
// @RestController・・・リクエストを受け、JSONやXML返す
//　　　　　　　　　　　　　DI可能(@Autowired可能)なコンポーネントとして扱う(DIコンテナに登録)
@RestController
public class DemoController {

    //Serviceクラスのインスタンスを取得
    // @Autowired・・・DIコンテナに登録されているBean(コンポーネント)のインスタンスを呼び出し
    @Autowired
    DemoService service;

    // @PostMapping・・・URL("/hello")とメソッド(index())を紐づけ
    @PostMapping("/hello")
    String index(){
        return service.hello();
    }

    // @PostMapping・・・URL("/good")とメソッド(goodBy())を紐づけ
    @PostMapping("/good")
    String goodBy(){
        return service.good();
    }

    // @PostMapping・・・URL("/good")とメソッド(goodBy())を紐づけ
    @PostMapping(value = "/getDataAccess", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DemoDto getDbData(@Validated @RequestBody JsonRequest jsonRequest, BindingResult bindingResult) throws Exception{
    	
    	// エラーチェック
    	if (bindingResult.hasErrors()) {
    		System.out.println("!!!! パターンエラー発生 !!!!");
    		System.out.println(bindingResult.getFieldError().getDefaultMessage());
    		throw new ValidatedException("E_001", bindingResult.getFieldError().getDefaultMessage());
    		//throw new Exception();
    		
    		// エラー返すやり方調べてやる
    		// junit作る
    		// validatedのパターンを作る
    		// max min入れてみる
    	}
        DemoDto dto = new DemoDto(jsonRequest.getUserId());
        DemoDto resultDto = service.getData(dto);
        return resultDto;
    }

    @PostMapping(value = "/getJson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    String getJsonData(@RequestBody JsonRequest jsonRequest) {      // @RequestBodyはjson形式でリクエストを受け取る
        System.out.println(jsonRequest.toString());
        return "コンソールを確認";
    }
}
