package com.nl.banking.mortgage.mortgagecalculator.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MortgageCheckResult {

    private boolean isFeasible;
    private double monthlyPayment;

    public MortgageCheckResult(boolean isFeasible, double monthlyPayment) {
        this.isFeasible = isFeasible;
        this.monthlyPayment = monthlyPayment;
    }
}

