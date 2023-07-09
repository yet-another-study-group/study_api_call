package com.example.hn.homework1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ApiResponse<T> {

    private final String message;
    private final int code;
    private final T data;

    public static <T> ApiResponse<T> ok(T data){
        return new ApiResponse<>(
                "성공",
                200,
                data
        );
    }
}
