package com.example.demo.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AddressSearchApiResultResponse {
	
	/** ステータス(正常時は 200、エラー発生時にはエラーコードが返される。) */
    private int status;

    /** エラー発生時に、エラーの内容が返される。 */
    private String message;
    
    private List<AddressResponse> results = new ArrayList<>();
}
