package com.study.hyy.controller;

import com.study.hyy.dto.ABResponseDto;
import com.study.hyy.service.FeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeignController {

    private final FeignService exService;

    // 숙제 API
    @GetMapping("/answer")
    public ResponseEntity<ABResponseDto> getAB() {

        ABResponseDto abResult = exService.calculateAB();

        return ResponseEntity.ok(abResult);
    }

    // 영기님 값 받아오는 API(잘 받아오는지 확인용)
    @GetMapping("/yk")
    public int getYkResult() {

        int ykResult = exService.getYkAPi();

        return ykResult;

    }
}
