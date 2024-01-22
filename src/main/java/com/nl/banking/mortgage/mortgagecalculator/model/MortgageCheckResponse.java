package com.nl.banking.mortgage.mortgagecalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class MortgageCheckResponse {

    private boolean feasible;
    private double monthlyCosts;

    public MortgageCheckResponse(boolean feasible, double monthlyCosts) {
        this.feasible = feasible;
        this.monthlyCosts = monthlyCosts;
    }
}
