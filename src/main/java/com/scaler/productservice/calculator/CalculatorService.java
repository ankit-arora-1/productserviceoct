package com.scaler.productservice.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int addFromService(int a, int b) {
        System.out.println("Calling from cal service, log 1");
        System.out.println("Calling from cal service, log 2");
        return a + b;
    }
}
