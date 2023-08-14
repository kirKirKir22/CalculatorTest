package com.example.calculatorTest.calculatorTest.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public int addTwoNumbers(int num1, int num2) {

        int result = num1 + num2;
        return result;
    }

    @Override
    public int subtractTwoNumbers(int num1, int num2) {

        int result = num1 - num2;
        return result;

    }

    @Override
    public int multiplyTwoNumbers(int num1, int num2) {

        int result = num1 * num2;
        return result;

    }

    @Override
    public double divideTwoNumbers(int num1, int num2) {

        double result = (double) num1 / num2;
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return result;

    }

}
