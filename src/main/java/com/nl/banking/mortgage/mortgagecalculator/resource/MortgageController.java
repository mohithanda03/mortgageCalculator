package com.nl.payments.mortgagecalculator.resource;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import com.nl.payments.mortgagecalculator.service.MortgageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mohit
 * Type Mortgage Controller Exposes interestRate Endpoints.
 */
@Tag(name = "Mortgage API", description = "Mortgage Calculator API")
@RestController
@RequestMapping("/mortgage")
public class MortgageController {

    @Autowired
    private InterestRateService interestRateService;

    @Autowired
    private MortgageService mortgageService;

    /**
     * Gets all the interest Rates.
     *
     * @return List of interest Rates.
     */
    @Operation(summary = "Get All Interest Rates")
    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRateService.getCurrentInterestRates();
    }

    /**
     * Creates a new Recipe.
     *
     * @param request Calculates monthly costs based on given fields.
     * @return Response as feasibility and monthly cost.
     */
    @Operation(summary = "Mortgage Check")
    @PostMapping("/mortgage-check")
    public MortgageCheckResponse performMortgageCheck(@Validated @RequestBody MortgageCheckRequest request) {
        return mortgageService.performMortgageCheck(request);
    }
}
