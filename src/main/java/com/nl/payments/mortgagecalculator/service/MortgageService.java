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

    /**
     * Perform a mortgage check based on the provided request.
     *
     * @param request the mortgage request
     * @return the mortgage feasibility response
     */
    MortgageCheckResponse performMortgageCheck(MortgageCheckRequest request);

}
