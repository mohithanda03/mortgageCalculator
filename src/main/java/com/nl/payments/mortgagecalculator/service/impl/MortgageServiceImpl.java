package com.nl.payments.mortgagecalculator.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import com.nl.payments.mortgagecalculator.service.MortgageService;
import com.nl.payments.mortgagecalculator.utils.CalcUtil;

import java.math.BigDecimal;

/**
 * @author Mohit
 * Type MortgageServiceImpl Implements  the MortgageService.
 */
@Service
public class MortgageServiceImpl implements MortgageService {

    @Autowired
    private InterestRateService interestRateService;

    @Override
    public MortgageCheckResponse performMortgageCheck(MortgageCheckRequest request) {
        double interestRate = interestRateService.getInterestRateByMaturityPeriod(request.getMaturityPeriod());

        boolean feasible = CalcUtil.isFeasible(request);
        BigDecimal monthlyCosts = CalcUtil.calculateMonthlyCosts(request, interestRate);
        return new MortgageCheckResponse(feasible, monthlyCosts);
    }


}
