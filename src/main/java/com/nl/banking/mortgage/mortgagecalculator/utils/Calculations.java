package com.nl.banking.mortgage.mortgagecalculator.utils;

import com.example.mortgage.calculator.model.MortgageCheckRequest;

import static com.example.mortgage.calculator.enums.Constants.MAXIMUM_TIMES_INCOME;
import static com.example.mortgage.calculator.enums.Constants.MONTHS_IN_A_YEAR;

public class Calculations {

    public static double calculateMonthlyCosts(MortgageCheckRequest request, double interestRate) {
        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR;
        int numberOfPayments = request.getMaturityPeriod() * MONTHS_IN_A_YEAR;
        double monthlyPayment;
        monthlyPayment = request.getLoanValue() * (
                (interestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        (Math.pow(1 + monthlyInterestRate, numberOfPayments ) - 1)
        );
        return monthlyPayment;
    }

    public static Boolean isFeasible(MortgageCheckRequest request) {

        return request.getLoanValue() < request.getIncome()* MAXIMUM_TIMES_INCOME &&
                request.getLoanValue() < request.getHomeValue();
    }
}
