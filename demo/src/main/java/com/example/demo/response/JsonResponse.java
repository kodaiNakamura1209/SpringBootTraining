package com.example.demo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

// 処理した情報をJson形式で返す
@Getter
@Setter
@ToString
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
}
