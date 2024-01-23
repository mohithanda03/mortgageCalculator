package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.MortgageCalculatorApplication;
import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.service.InterestRateService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohit
 * Type InterestRateServiceImpl Implements  the InterestRateService.
 */
@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Override
    public List<InterestRate> getCurrentInterestRates() {
        return MortgageCalculatorApplication.INTEREST_RATES;
    }

    @Override
    public double getInterestRateByMaturityPeriod(int maturityPeriod) {
        double interestRate = 0;
        interestRate = MortgageCalculatorApplication.INTEREST_RATES.get(maturityPeriod - 1).getInterestRatePercentage();
        return interestRate;
    }

}
