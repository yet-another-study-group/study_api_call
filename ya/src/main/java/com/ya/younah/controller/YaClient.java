package com.ya.younah.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "YaClient", url = "http://localhost:8081/api")
public interface YaClient {
    @GetMapping("/cal/{x}")
    public Integer calculateQuadraticEquation(@PathVariable("x") int x);


}
