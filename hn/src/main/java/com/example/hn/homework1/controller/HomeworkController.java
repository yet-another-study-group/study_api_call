package com.example.hn.homework1.controller;

import com.example.hn.homework1.response.ABResponse;
import com.example.hn.homework1.response.ApiResponse;
import com.example.hn.homework1.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    @GetMapping("/hn/homework1")
    public ApiResponse getAnswer(){

        ABResponse response=homeworkService.getAnswer();
        return ApiResponse.ok(response);
    }
}
