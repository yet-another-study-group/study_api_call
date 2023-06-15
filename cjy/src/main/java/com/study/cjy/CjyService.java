package com.study.cjy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CjyService {
    private final YkOpenFeign openFeign;
    public String algorithm() {
        int xIsOne = openFeign.getResult(1);
        int xIsTwo = openFeign.getResult(2);

        int a = (xIsTwo - 2 * xIsOne) / 2;
        int b = xIsOne - a;

        String result = "a = " + Integer.toString(a) + ", b = " + Integer.toString(b);
        return result;
    }
}
