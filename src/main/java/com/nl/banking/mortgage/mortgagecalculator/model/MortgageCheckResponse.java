package com.nl.payments.mortgagecalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Mohit
 * Type Mortgage Controller Exposes interestRate Endpoints.
 */
@Setter
@Getter
public class MortgageCheckResponse {

    private boolean feasible;
    private BigDecimal monthlyCosts;

    public MortgageCheckResponse(boolean feasible, BigDecimal monthlyCosts) {
        this.feasible = feasible;
        this.monthlyCosts = monthlyCosts;


    }
}
