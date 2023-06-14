package com.example.hn.homework1.service;

import com.example.hn.homework1.response.ABResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;


@Service
@RequiredArgsConstructor
@Slf4j
public class HomeworkService {

    private final YkService ykService;

    public ABResponse getAnswer() {
        int x1 = 2;
        int x2 = 3;
        int answer1 = ykService.getAnswer(x1);
        int answer2 = ykService.getAnswer(x2);

        double[][] matrixData = {
                {x1 * x1, x1},
                {x2 * x2, x2}
        };
        log.debug(printMatrix(matrixData));

        double[] resultData = {answer1, answer2};


        RealMatrix matrix = new Array2DRowRealMatrix(matrixData);
        RealMatrix resultMatrix = new Array2DRowRealMatrix(resultData);


        RealMatrix inverseMatrix = MatrixUtils.inverse(matrix);
        log.debug(printMatrix(inverseMatrix.getData()));


        RealMatrix solutionMatrix = inverseMatrix.multiply(resultMatrix);


        double[] solution = solutionMatrix.getColumn(0);
        int a = (int) Math.round(solution[0]);
        int b = (int) Math.round(solution[1]);
        log.debug("a:" + a + ", b:" + b);


        return ABResponse.of(a, b);

    }

    public String printMatrix(double[][] matrix) {
        StringBuilder str = new StringBuilder();
        IntStream.range(0, matrix.length)
                .forEach(e -> str.append(Arrays.toString(matrix[e]) + "\n"));

        return str.toString();
    }
}
