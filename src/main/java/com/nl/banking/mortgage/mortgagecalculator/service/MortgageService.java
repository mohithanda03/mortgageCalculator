package com.nl.payments.mortgagecalculator.service;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import org.springframework.stereotype.Service;

/**
 * @author Mohit
 * Type MortgageService handles operation on the Mortgage Calculation.
 */
@Service
public interface MortgageService {

    MortgageCheckResponse performMortgageCheck(MortgageCheckRequest request);

}
