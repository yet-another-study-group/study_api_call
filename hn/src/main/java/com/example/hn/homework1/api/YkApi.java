package com.example.hn.homework1.api;

import com.example.hn.homework1.response.YkServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "homework1-yk", url = "http://localhost:8081")
public interface YkApi {
    @GetMapping(value = "/api/cal/{x}")
    YkServiceResponse getAnswer(@PathVariable("x") int x);
}
