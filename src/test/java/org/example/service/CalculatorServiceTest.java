package org.example.service;

import org.example.exception.DivByZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void when_pass_any_two_numbers_to_for_adding_then_get_result() {
        // given
        int a = 1;
        int b = 1;
        Number expected = 2;

        // invoking
        Number actual = calculatorService.plus(a, b);

        // assertion
        Assertions.assertEquals(expected, actual);

        b = -1;
        expected = 0;

        actual = calculatorService.plus(a, b);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void minusTest() {
        // given
        int a = 1;
        int b = 1;
        Number expected = 0;

        // invoking
        Number actual = calculatorService.minus(a, b);

        // assertion
        Assertions.assertEquals(expected, actual);

        b = -1;
        expected = 2;

        actual = calculatorService.minus(a, b);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest() {
        // given
        int a = 1;
        int b = 1;
        Number expected = 1;

        // invoking
        Number actual = calculatorService.multiply(a, b);

        // assertion
        Assertions.assertEquals(expected, actual);

        b = -1;
        expected = -1;

        actual = calculatorService.multiply(a, b);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void dividePositiveTest() {
        // given
        int a = 1;
        int b = 1;
        Number expected = 1;

        // invoking
        Number actual = calculatorService.divide(a, b);

        // assertion
        Assertions.assertEquals(expected, actual);

        b = -1;
        expected = -1;

        actual = calculatorService.divide(a, b);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void divideNegativeTest() {
        // given
        int a = 1;
        int b = 0;

        // invoking and assertion
        Assertions.assertThrows(DivByZeroException.class, () -> calculatorService.divide(a, b));
    }
}
