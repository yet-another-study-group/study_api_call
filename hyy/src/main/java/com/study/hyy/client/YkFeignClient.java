package com.study.hyy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "YkFeignClient", url="http://localhost:8081")
public interface YkFeignClient {

    @GetMapping(value = "/api/cal/{x}")
    int getValue(@PathVariable("x") int x);

}
