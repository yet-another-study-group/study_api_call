package com.study.cjy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "YkOpenFeign", url = "http://localhost:8081")
public interface YkOpenFeign {
    @GetMapping("/api/cal/{x}")
    int getResult(@PathVariable("x") int x);
}
