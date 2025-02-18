package com.scaler.productservice.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CalculatorControllerTest {
    private CalculatorService calculatorServiceDummy =
            Mockito.mock(CalculatorService.class);


    private CalculatorController calculatorController =
            new CalculatorController(calculatorServiceDummy);

    @Test
    public void testAdd() {
        when(calculatorServiceDummy.addFromService(10, 5))
                .thenReturn(15);

        int a = 10;
        int b = 5;
        int result = calculatorController.add(a, b);

        Assertions.assertEquals(15, result);
    }
}
