package com.example.CalculatorApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CalculatorApp.service.CalculationService;

@RestController
public class CalculationController {
    private static final Logger LOGGER=LoggerFactory.getLogger(CalculationController.class);
    @Autowired
    private CalculationService calculationService;

    @GetMapping("/calculate")
    public String calculate() {
        LOGGER.info("Request Coming For Calling Thread");
        Thread th=new Thread(calculationService.calculateSquare());
        th.start();
       // new Thread(calculationService.calculateSquare(number)).start();
        new Thread(calculationService.calculateCube()).start();
        new Thread(calculationService.checkEvenOdd()).start();
        new Thread(calculationService.checkPrime()).start();
        new Thread(calculationService.checkArmstrong()).start();
        new Thread(calculationService.checkPalindrome()).start();
        new Thread(calculationService.calculateFactorial()).start();
        LOGGER.info("Response Send Succesfully....");
        return "Calculations started .....";
    }
}
