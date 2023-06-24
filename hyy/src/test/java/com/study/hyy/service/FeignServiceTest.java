package com.study.hyy.service;

import com.study.hyy.client.YkFeignClient;
import com.study.hyy.dto.ABResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeignServiceTest {
    @InjectMocks
    FeignService feignService;

    @Mock
    YkFeignClient ykFeignClient;

    @Test
    @DisplayName("과제1 calculateAB() 테스트코드")
    void successCalculateAB() {
        given(ykFeignClient.getValue(14)).willReturn(2912);
        given(ykFeignClient.getValue(40)).willReturn(22880);

        ABResponseDto abResponseDto = feignService.calculateAB();

        then(ykFeignClient).should(times(1)).getValue(14);
        then(ykFeignClient).should(times(1)).getValue(40);
        then(ykFeignClient).shouldHaveNoMoreInteractions();

        assertThat(abResponseDto.getA()).isEqualTo(14);
        assertThat(abResponseDto.getB()).isEqualTo(12);
    }
}
