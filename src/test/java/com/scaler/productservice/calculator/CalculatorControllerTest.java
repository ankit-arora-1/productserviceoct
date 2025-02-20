package com.scaler.productservice.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorControllerTest {
//    private CalculatorService calculatorServiceDummy =
//            Mockito.mock(CalculatorService.class);
//
//
//    private CalculatorController calculatorController =
//            new CalculatorController(calculatorServiceDummy);

    @Autowired
    private CalculatorController calculatorController;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.addFromService(anyInt(), anyInt()))
                .thenReturn(15);

        int a = 10;
        int b = 5;
        int result = calculatorController.add(a, b);

        Assertions.assertEquals(15, result);
    }
}
