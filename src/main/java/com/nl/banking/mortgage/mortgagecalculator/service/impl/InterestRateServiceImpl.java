package com.nl.banking.mortgage.mortgagecalculator.service.impl;

import com.example.mortgage.calculator.model.InterestRate;
import com.example.mortgage.calculator.service.InterestRateService;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example.mortgage.calculator.MortgageCalculatorApplication.INTEREST_RATES;

@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Override
    public List<InterestRate> getCurrentInterestRates() {
        return INTEREST_RATES;
    }

    @Override
    public double getInterestRateByMaturityPeriod(int maturityPeriod) {
        double interestRate = 0;
        interestRate = INTEREST_RATES.get(maturityPeriod).getInterestRate();
        return interestRate;
    }

}

