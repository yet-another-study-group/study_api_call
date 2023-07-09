package com.example.hn.homework1.service;

import com.example.hn.MockYkApi;
import com.example.hn.WireMockConfig;
import com.example.hn.homework1.api.YkApi;
import com.example.hn.homework1.response.YkServiceResponse;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
        properties = {"feign.ykapi-url=http://localhost:8081"})
@ContextConfiguration(classes = {WireMockConfig.class})
class YkServiceTest {

    @Autowired
    private WireMockServer mockServer;

    @Autowired
    private YkApi ykApi;

    @DisplayName("api get answer Success test")
    @Test
    void getAnswerSuccessTest() throws IOException {
        //given
        int x = 2;
        String expectedApiUrl = "/api/cal/" + x;
        int expectedAnswer = 80;
        MockYkApi.setupGetAnswerResponse(mockServer, expectedApiUrl);

        YkServiceResponse test = ykApi.getAnswer(x);

        assertEquals(test.getAnswer(), expectedAnswer);
    }
}