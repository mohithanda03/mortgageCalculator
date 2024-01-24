package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.exception.InterestRateNotFoundException;
import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.repository.InterestRateRepository;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nl.payments.mortgagecalculator.enums.ErrorMessage.INTEREST_RATE_NOT_FOUND;
import static com.nl.payments.mortgagecalculator.enums.ErrorMessage.MATURITY_PERIOD_IS_ZERO;

/**
 * @author Mohit
 * Type InterestRateServiceImpl Implements  the InterestRateService.
 */
@Slf4j
@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Autowired
    private InterestRateRepository interestRateRepository;

    public InterestRateServiceImpl (InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    /**
     * Retrieves the current interest rates.
     *
     * @return a list of InterestRate objects representing the current interest rates
     */
    @Override
    public List<InterestRate> getCurrentInterestRates() {
        return interestRateRepository.getAllInterestRate();
    }

    /**
     * Get the interest rate based on the maturity period.
     *
     * @param maturityPeriod the maturity period for which mortgage is required
     * @return the interest rate corresponding to the given maturity period
     */
    @Override
    public double getInterestRateByMaturityPeriod(int maturityPeriod) {
        double interestRate;
        if (maturityPeriod != 0) {
            try {
                interestRate = interestRateRepository.getInterestRateByMaturityPeriod(maturityPeriod - 1)
                        .getInterestRatePercentage();
            } catch (IndexOutOfBoundsException e) {
                throw new InterestRateNotFoundException(INTEREST_RATE_NOT_FOUND + maturityPeriod);
            }
            return interestRate;
        } else {
            throw new NegativeArraySizeException(MATURITY_PERIOD_IS_ZERO);
        }
    }
}