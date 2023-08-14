package com.example.calculatorTest.calculatorTest.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService underTest = new CalculatorServiceImpl();

    @Test
    void helloCalculator__returnWelcomeString() {
        String result = underTest.helloCalculator();
        assertEquals("Добро пожаловать в калькулятор", result);// почему байт?
    }

    @Test
    void addTwoNumbers_addPositiveNumbers() {
        var result = underTest.addTwoNumbers(100, 100);
        assertEquals(200, result);
    }

    @Test
    void addTwoNumbers_addUpNegativeNumbers() {
        var result = underTest.addTwoNumbers(-100, 100);
        assertEquals(0, result);

    }

    @Test
    void AddTwoNumbers_Overflow() {
        int bigNum = Integer.MAX_VALUE;
        int result = underTest.addTwoNumbers(bigNum, 1);

        assertTrue(result < bigNum);
        assertFalse(result > bigNum);
    }

    @Test
    void subtractTwoNumbers_positive() {
        int result = underTest.subtractTwoNumbers(10, 5);
        assertEquals(5, result);
    }

    @Test
    void subtractTwoNumbers_negative() {
        int result = underTest.subtractTwoNumbers(5, 10);
        assertEquals(-5, result);
    }

    @Test
    void subtractTwoNumbers_negativeNegative() {
        int result = underTest.subtractTwoNumbers(-5, -10);
        assertEquals(5, result);
    }

    @Test
    void multiplyTwoNumbers_Positive() {
        int result = underTest.multiplyTwoNumbers(5, 5);
        assertEquals(25, result);

    }

    @Test
    void multiplyTwoNumbers_Negative() {
        int result = underTest.multiplyTwoNumbers(-5, 5);
        assertEquals(-25, result);

    }

    @Test
    void MultiplyTwoNumbers_MaxValueCheck() {

        int result = underTest.multiplyTwoNumbers(20_000_00, 20_000_00);
        assertTrue(result < Integer.MAX_VALUE);
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
}