package com.example.hn.homework1.service;

import com.example.hn.homework1.api.YkApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class YkService {

    private final YkApi ykApi;

    public int getAnswer(int x) {
        int answer=ykApi.getAnswer(x).getAnswer();
        log.debug("answer="+answer);
        return answer;
    }
}
