package com.nl.payments.mortgagecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Mohit
 * Type MortgageCheckResponse holds the response parameters for mortgage response.
 */
@Data
@AllArgsConstructor
public class MortgageCheckResponse {

    private boolean feasible;
    private BigDecimal monthlyCosts;
}