package com.scaler.productservice.calculator;

public class CalculatorService {
    public int addFromService(int a, int b) {
        System.out.println("Calling from cal service, log 1");
        System.out.println("Calling from cal service, log 2");
        return a + b;
    }
}
