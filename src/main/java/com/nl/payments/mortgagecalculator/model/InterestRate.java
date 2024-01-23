package com.nl.payments.mortgagecalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class InterestRate {
    private int maturityPeriod;
    private double interestRatePercentage;
    private Timestamp lastUpdate;

    public InterestRate(int maturityPeriod, double interestRatePercentage, Timestamp lastUpdate) {
        this.maturityPeriod = maturityPeriod;
        this.interestRatePercentage = interestRatePercentage;
        this.lastUpdate = lastUpdate;
    }
}

