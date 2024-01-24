package com.nl.payments.mortgagecalculator.service;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mohit
 * Type InterestRateService handles operation on the InterestRate.
 */
@Service
public interface InterestRateService {

    List<InterestRate> getCurrentInterestRates();

    /**
     * Get the interest rate by maturity period.
     *
     * @param maturityPeriod the maturity period for which mortgage is required
     * @return the interest rate corresponding to the given maturity period
     */
    double getInterestRateByMaturityPeriod(int maturityPeriod);
}