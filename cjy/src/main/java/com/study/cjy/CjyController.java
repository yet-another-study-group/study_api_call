package com.study.cjy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CjyController {
    private final CjyService cjyService;

    @GetMapping("/getNum")
    public String getNum() {
        String result = cjyService.algorithm();
        return result;
    }
}
