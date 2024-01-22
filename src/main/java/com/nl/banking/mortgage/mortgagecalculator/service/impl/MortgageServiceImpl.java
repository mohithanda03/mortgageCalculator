package com.nl.banking.mortgage.mortgagecalculator.service.impl;

import com.example.mortgage.calculator.model.MortgageCheckRequest;
import com.example.mortgage.calculator.model.MortgageCheckResponse;
import com.example.mortgage.calculator.service.InterestRateService;
import com.example.mortgage.calculator.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.mortgage.calculator.utils.Calculations.calculateMonthlyCosts;
import static com.example.mortgage.calculator.utils.Calculations.isFeasible;

@Service
public class MortgageServiceImpl implements MortgageService {

    @Autowired
    private InterestRateService interestRateService;

    @Override
    public MortgageCheckResponse performMortgageCheck(MortgageCheckRequest request) {
        double interestRate = interestRateService.getInterestRateByMaturityPeriod(request.getMaturityPeriod());

        boolean feasible = isFeasible(request);
        double monthlyCosts = calculateMonthlyCosts(request, interestRate);

        return new MortgageCheckResponse(feasible, monthlyCosts);
    }




}
