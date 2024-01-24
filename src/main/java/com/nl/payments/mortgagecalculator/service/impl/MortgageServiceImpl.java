package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import com.nl.payments.mortgagecalculator.service.MortgageService;
import com.nl.payments.mortgagecalculator.utils.CalcUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Mohit
 * Type MortgageServiceImpl Implements  the MortgageService.
 */
@Slf4j
@Service
public class MortgageServiceImpl implements MortgageService {

    @Autowired
    private InterestRateService interestRateService;

    /**
     * Performs a mortgage check based on the provided request.
     *
     * @param request the mortgage request
     * @return the mortgage feasibility response
     */
    @Override
    public MortgageCheckResponse performMortgageCheck(@NonNull MortgageCheckRequest request) {
        double interestRate = interestRateService.getInterestRateByMaturityPeriod(request.getMaturityPeriod());
        boolean feasible = CalcUtil.isFeasible(request);
        BigDecimal monthlyCosts = CalcUtil.calculateMonthlyCosts(request, interestRate);
        log.info("MortgageCheck Response- Sent");
        return new MortgageCheckResponse(feasible, monthlyCosts);
    }
}
