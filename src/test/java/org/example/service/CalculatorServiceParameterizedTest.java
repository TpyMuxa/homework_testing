package org.example.service;

import org.example.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> paramsForPlusTest() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(1, -1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForPlusTest")
    public void plusTest(Integer a, Integer b, Integer expected) {
        Number actual = calculatorService.plus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForMinusTest() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(1, -1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForMinusTest")
    public void minusTest(Integer a, Integer b, Integer expected) {
        Number actual = calculatorService.minus(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForMultiplyTest() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(1, -1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplyTest")
    public void multiplyTest(Integer a, Integer b, Integer expected) {
        Number actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForDividePositiveTest() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(1, -1, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForDividePositiveTest")
    public void dividePositiveTest(Integer a, Integer b, Integer expected) {
        Number actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> paramsForDivideNegativeTest() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForDivideNegativeTest")
    public void divideNegativeTest(Integer a, Integer b) {
        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.divide(a, b));
    }
}
