package com.example.calculatorTest.calculatorTest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService underTest = new CalculatorServiceImpl();

    @Test
    void helloCalculator__returnWelcomeString() {
        String result = underTest.helloCalculator();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void addTwoNumbers_num1AndNum2Positive_resultPositive() {
        var result = underTest.addTwoNumbers(100, 100);
        assertEquals(200, result);
    }

    @Test
    void addTwoNumbers_num1AndNum2Negative_resultNegative() {
        var result = underTest.addTwoNumbers(-100, -100);
        assertEquals(-200, result);

    }

    @Test
    void AddTwoNumbers_num1AndNum2_doesNotIncreaseIntInSum() {
        int result = underTest.addTwoNumbers(Integer.MAX_VALUE - 1, 2);
        assertEquals(Integer.MAX_VALUE + 1, result);

    }

    @Test
    void subtractTwoNumbers_num1AndNum2Positive_resultPositive() {
        int result = underTest.subtractTwoNumbers(10, 5);
        assertEquals(5, result);
    }

    @Test
    void subtractTwoNumbers_num1AndNum2Negative_resultNegative() {
        int result = underTest.subtractTwoNumbers(-10, -5);
        assertEquals(-5, result);
    }

    @Test
    void subtractTwoNumbers_num1AndNum2_doesNotIncreaseIntInSum() {
        int result = underTest.subtractTwoNumbers(0, -(Integer.MAX_VALUE + 1));
        assertEquals((-Integer.MAX_VALUE - 1), result);
    }

    @Test
    void multiplyTwoNumbers_num1AndNum2Positive_resultPositive() {
        int result = underTest.multiplyTwoNumbers(5, 5);
        assertEquals(25, result);

    }

    @Test
    void multiplyTwoNumbers_num1AndNum2Negative_resultPositive() {
        int result = underTest.multiplyTwoNumbers(-5, -5);
        assertEquals(25, result);

    }

    @Test
    void divideTwoNumbers_divisionWithoutRemainder() {
        var result = underTest.divideTwoNumbers(4, 2);
        assertEquals(2, result);
    }

    @Test
    void divideTwoNumbers_divisionWithRemainder() {
        var result = underTest.divideTwoNumbers(5, 2);
        assertEquals(2.5, result);

    }

    @Test
    void divideTwoNumbers_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> underTest.divideTwoNumbers(2, 0));

    }

    @ParameterizedTest
    @MethodSource("numsForAddTwoNumbers")
    void AddTwoNumbers__returnSum(int num1, int num2, int expectedResult) {
        var result = underTest.addTwoNumbers(num1, num2);
        assertEquals(expectedResult, result);

    }

    private static Stream<Arguments> numsForAddTwoNumbers() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(-5, -5, -10)
        );
    }

    @ParameterizedTest
    @MethodSource("numsForSubtractTwoNumbers")
    void subtractTwoNumbers__returnResidual(int num1, int num2, int expectedResult) {
        var result = underTest.subtractTwoNumbers(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> numsForSubtractTwoNumbers() {
        return Stream.of(
                Arguments.of(10, 10, 0),
                Arguments.of(10, -10, 20)

        );
    }

    @ParameterizedTest
    @MethodSource("numsFormultiplyTwoNumbers")
    void multiplyTwoNumbers_returnMultiplicationResult(int num1, int num2, int expectedResult){
        var result = underTest.multiplyTwoNumbers(num1,num2);
        assertEquals(expectedResult,result);
    }
    private static Stream<Arguments> numsFormultiplyTwoNumbers(){
        return Stream.of(
                Arguments.of(2,2,4),
                Arguments.of(-2,-2,4)
        );
    }


    @ParameterizedTest
    @MethodSource("numsForDivideTwoNumbers")
    void divideTwoNumbers__returnDouble(int num1, int num2, double expectedResult) {
        var result = underTest.divideTwoNumbers(num1, num2);
        assertEquals(expectedResult, result);

    }

    private static Stream<Arguments> numsForDivideTwoNumbers() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(5, 2, 2.5)
        );
    }

}