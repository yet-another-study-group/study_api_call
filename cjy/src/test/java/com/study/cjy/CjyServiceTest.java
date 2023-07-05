package com.study.cjy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CjyServiceTest {

    @InjectMocks
    CjyService cjyService;

    @Mock
    YkOpenFeign ykOpenFeign;

    @Test
    @DisplayName("과제1 서비스 코드 테스트")
    void test1() {
        when(ykOpenFeign.getResult(1)).thenReturn(2); // a + b = 2
        when(ykOpenFeign.getResult(2)).thenReturn(6); // 4a + 2b = 6

        ResponseDto responseDto = cjyService.algorithm();

        assertThat(responseDto.getA()).isEqualTo(1);
        assertThat(responseDto.getB()).isEqualTo(1);
    }
}