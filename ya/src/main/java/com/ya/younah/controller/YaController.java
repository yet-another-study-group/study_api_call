package com.ya.younah.controller;

import com.ya.younah.service.YaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class YaController {
    private final YaService yaService;

    @GetMapping("/{x}") //{} <<람다어쩌구: 변수 표현방식
    public String ykApiCall(@PathVariable("x") int x){

        return yaService.ykCallService(x);
    }

}
