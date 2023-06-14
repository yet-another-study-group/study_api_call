package com.example.hn.homework1.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ABResponse {
    private int a;
    private int b;

    public static ABResponse of(int a, int b) {
        ABResponse abResponse=new ABResponse();
        abResponse.setA(a);
        abResponse.setB(b);
        return abResponse;
    }
}
