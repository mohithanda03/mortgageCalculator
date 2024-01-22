package com.nl.banking.mortgage.mortgagecalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class MortgageCheckRequest {

    private double income;
    private int maturityPeriod;
    private double loanValue;
    private double homeValue;

    /**/

    public MortgageCheckRequest(double income, int maturityPeriod, double loanValue, double homeValue) {
        this.income = income;
        this.maturityPeriod = maturityPeriod;
        this.loanValue = loanValue;
        this.homeValue = homeValue;
    }

}

