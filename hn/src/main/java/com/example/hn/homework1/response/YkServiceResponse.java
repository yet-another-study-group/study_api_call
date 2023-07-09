package com.example.hn.homework1.response;

import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YkServiceResponse {
    private int answer;
}
