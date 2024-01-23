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


    double getInterestRateByMaturityPeriod(int maturityPeriod);
}
