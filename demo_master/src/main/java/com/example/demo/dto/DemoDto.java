package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DemoDto {
    public DemoDto(String userId){
        this.userId = userId;
    }

	private String userId;

    private String userName;
}
