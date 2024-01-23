package com.nl.payments.mortgagecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Mohit
 * Type InterestRate holds the interest rate details.
 */
@Data
@AllArgsConstructor
public class InterestRate {
    private int maturityPeriod;
    private double interestRatePercentage;
    private Timestamp lastUpdate;
}
