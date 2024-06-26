package com.example.CalculatorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CalculatorApp.service.CalculationService;

@RestController
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @PostMapping("/calculate")
    public String calculate(@RequestParam int number) {
        // Start threads for each calculation
        new Thread(calculationService.calculateSquare(number)).start();
        new Thread(calculationService.calculateCube(number)).start();
        new Thread(calculationService.checkEvenOdd(number)).start();
        new Thread(calculationService.checkPrime(number)).start();
        new Thread(calculationService.checkArmstrong(number)).start();
        new Thread(calculationService.checkPalindrome(number)).start();
        new Thread(calculationService.calculateFactorial(number)).start();
      //  new Thread(calculationService.calculateReverse(number)).start();

        return "Calculations started for number: " + number;
    }
}
