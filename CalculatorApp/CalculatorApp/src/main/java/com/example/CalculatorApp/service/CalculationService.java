package com.example.CalculatorApp.service;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.CalculatorApp.controller.CalculationController;

@Service
public class CalculationService {
    Scanner sc=new Scanner (System.in);
    static{
        System.out.println("Enter Number");
    }
    int n=sc.nextInt();
    private static final Logger LOGGER=LoggerFactory.getLogger(CalculationController.class);

    public Runnable calculateSquare() {
        LOGGER.info("Getting Square....");
        return () -> {
            int square = n * n;
            System.out.println("Square of " + n + " is: " + square);
        };
    }

    public Runnable calculateCube() {
        LOGGER.info("Getting Cube....");
        return () -> {
            int cube = n * n * n;
            System.out.println("Cube of " + n + " is: " + cube);
        };
    }

    public Runnable checkEvenOdd() {
        LOGGER.info("Checking Number....");

        return () -> {
            String evenOdd = (n % 2 == 0) ? "Even" : "Odd";
            System.out.println(n + " is " + evenOdd);
        };
    }

    public Runnable checkPrime() {
        LOGGER.info("Checking Number Is prime or not....");

        return () -> {
            boolean isPrime = true;
            if (n <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            System.out.println(n + " is prime? " + isPrime);
        };
    }

    public Runnable checkArmstrong() {
        LOGGER.info("Checking Number is Amstrong or not");
        return () -> {
            int originalNumber, remainder, result = 0, digits = 0;

            originalNumber = n;

          
            for (int temp = originalNumber; temp != 0; temp /= 10) {
                digits++;
            }

    
            for (int temp = originalNumber; temp != 0; temp /= 10) {
                remainder = temp % 10;
                result += Math.pow(remainder, digits);
            }

            if (result == originalNumber) {
                System.out.println(originalNumber + " is an Armstrong number.");
            } else {
                System.out.println(originalNumber + " is not an Armstrong number.");
            }
        };
    }

    public Runnable checkPalindrome() {
        LOGGER.info("Checking number pelindrome");

        return () -> {
            int originalNumber, reversedNumber = 0, remainder;

            originalNumber = n;

           
            for (int temp = originalNumber; temp != 0; temp /= 10) {
                remainder = temp % 10;
                reversedNumber = reversedNumber * 10 + remainder;
            }

            if (originalNumber == reversedNumber) {
                System.out.println(originalNumber + " is a palindrome.");
            } else {
                System.out.println(originalNumber + " is not a palindrome.");
            }
        };
    }

    public Runnable calculateFactorial() {
        LOGGER.info("Calculating Factorial");
        return () -> {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + n + " is: " + factorial);
        };
    }

    public Runnable calculateReverse() {
        LOGGER.info("Calculating Rev Number");
        return () -> {
            int temp=n;
            int rev = 0;
            while (temp != 0) {
                int digit = temp% 10;
                rev = rev * 10 + digit;
                temp=n/10;
            }
            System.out.println("Reverse of " + n + " is: " + rev);
        };
    }
}
