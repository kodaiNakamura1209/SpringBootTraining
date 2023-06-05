package com.example.demo.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 画面から受け取った情報をJson形式で格納するクラス
@Getter
@Setter
@ToString
public class JsonRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{NotBlank.jsonRequest.userId}")
    private String userId;
}
