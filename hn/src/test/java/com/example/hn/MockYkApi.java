package com.example.hn;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MockYkApi {

    public static void setupGetAnswerResponse(WireMockServer wireMockServer, String url) throws IOException {
        Path file = ResourceUtils.getFile("classpath:test-response/ykapi-response.json").toPath();
        wireMockServer.stubFor(WireMock.get(WireMock.urlMatching(url))
                .willReturn(
                        WireMock.aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody(Files.readAllBytes(file))
                )
        );
    }
}
