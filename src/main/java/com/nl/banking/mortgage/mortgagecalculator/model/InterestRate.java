package com.nl.banking.mortgage.mortgagecalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class InterestRate {
    private int maturityPeriod;
    private double interestRate;
    private Timestamp lastUpdate;

    public InterestRate(int maturityPeriod, double interestRate, Timestamp lastUpdate) {
        this.maturityPeriod = maturityPeriod;
        this.interestRate = interestRate;
        this.lastUpdate = lastUpdate;
    }
}

