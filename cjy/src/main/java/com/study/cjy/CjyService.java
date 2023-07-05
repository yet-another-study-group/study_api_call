package com.study.cjy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CjyService {
    private final YkOpenFeign openFeign;
    public ResponseDto algorithm() {
        int xIsOne = openFeign.getResult(1);
        int xIsTwo = openFeign.getResult(2);

        int a = (xIsTwo - 2 * xIsOne) / 2;
        int b = xIsOne - a;

        return ResponseDto.of(a, b);
    }
}