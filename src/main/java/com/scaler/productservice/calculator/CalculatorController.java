package com.scaler.productservice.calculator;

public class CalculatorController {
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public int add(int a, int b) {
        System.out.println("Calculator controller log 1");
        System.out.println("Calculator controller log 2");
        int result = calculatorService.addFromService(a, b);

        System.out.println("Calc controller log 3");

        return result;
    }
}
