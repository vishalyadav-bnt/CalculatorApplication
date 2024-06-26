package com.example.CalculatorApp.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.example.CalculatorApp.service.CalculationService;;
    
    public class CalculatorControllerTest {
        @Mock
        CalculationService calculationService;
    
    
        @InjectMocks
        CalculationController calculationController;
        @Test      

        public void calculate_Success()
        {
        verify(calculationService, times(1)).calculateCube();
        verify(calculationService, times(1)).checkEvenOdd();
        verify(calculationService, times(1)).checkPrime();
        verify(calculationService, times(1)).checkArmstrong();
        verify(calculationService, times(1)).checkPalindrome();
        verify(calculationService, times(1)).calculateFactorial();
        }
    
    }
    
