package com.study.cjy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ResponseDto {
    private int a;
    private int b;

    public static ResponseDto of(int a, int b) {
        ResponseDto responseDto = new ResponseDto(a, b);
        return responseDto;
    }
}
