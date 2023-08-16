package com.example.calculatorTest.calculatorTest.controller;

import com.example.calculatorTest.calculatorTest.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String helloCalculator() {
        return calculatorService.helloCalculator();
    }

    @GetMapping(path = "/plus")
    public String addTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + calculatorService.addTwoNumbers(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String subtractTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " - " + num2 + " = " + calculatorService.subtractTwoNumbers(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiplyTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiplyTwoNumbers(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divideTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " / " + num2 + " = " + calculatorService.divideTwoNumbers(num1, num2);

    }


}
