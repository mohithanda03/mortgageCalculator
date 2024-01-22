package com.nl.banking.mortgage.mortgagecalculator.service;

import com.example.mortgage.calculator.model.InterestRate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterestRateService {

    List<InterestRate> getCurrentInterestRates();


    double getInterestRateByMaturityPeriod(int maturityPeriod);
}

