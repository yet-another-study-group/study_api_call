package com.study.hyy.service;

import com.study.hyy.client.YkFeignClient;
import com.study.hyy.dto.ABResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeignService {
    private final YkFeignClient ykFeignClient;

    public ABResponseDto calculateAB() {
        int x1 = 14;
        int result1 = ykFeignClient.getValue(x1);
        int x2 = 40;
        int result2 = ykFeignClient.getValue(x2);
        double[][] coefficients = {{x1 * x1, x1}, {x2 * x2, x2}};
        double[] constants = {result1, result2};
        RealMatrix matrix = MatrixUtils.createRealMatrix(coefficients);
        QRDecomposition solver = new QRDecomposition(matrix);
        RealVector constantsVector = MatrixUtils.createRealVector(constants);

        if (!solver.getSolver().isNonSingular())
            throw new IllegalArgumentException("방정식의 시스템에 유일한 해가 없습니다.");
        RealVector solution = solver.getSolver().solve(constantsVector);
        int a = (int) Math.round(solution.getEntry(0));
        int b = (int) Math.round(solution.getEntry(1));
        return new ABResponseDto(a, b);
    }

    public int getYkAPi() {
        int ykResult = ykFeignClient.getValue(3);
        return ykResult;
    }
}
