package com.ya.younah.service;

import com.ya.younah.controller.YaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YaService {

    private final YaClient yaClient;

    public String ykCallService(int x){

        Integer numA = yaClient.calculateQuadraticEquation(1);
        Integer numB = yaClient.calculateQuadraticEquation(2);

        Integer resultA = (numB - (numA*2))/2;

        Integer resultB = numA - resultA;

        String result = "a의 값은: "+resultA +"   b의 값은: "+resultB;

        return result;

    }

}
