package com.example.hn.homework1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ABResponse {
    private int a;
    private int b;

    public static ABResponse of(int a, int b) {
        return new ABResponse(a, b);
    }
}
