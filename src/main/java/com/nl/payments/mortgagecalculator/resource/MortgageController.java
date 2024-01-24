package com.nl.payments.mortgagecalculator.resource;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import com.nl.payments.mortgagecalculator.service.MortgageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    private final InterestRateService interestRateService;
    private final MortgageService mortgageService;

    @Autowired
    public MortgageController(MortgageService mortgageService, InterestRateService interestRateService) {
        this.mortgageService = mortgageService;
        this.interestRateService = interestRateService;
    }

    /**
     * Gets the list of interest Rates.
     *
     * @return List of interest Rates.
     */
    @Operation(summary = "Get All Interest Rates")
    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRateService.getCurrentInterestRates();
    }

    /**
     * Checks if the given fields are feasible for a mortgage  .
     *
     * @param request Calculates monthly costs based on given fields.
     * @return Response as feasibility and monthly cost.
     */
    @Operation(summary = "Mortgage Check")
    @PostMapping(path = "/mortgage-check", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MortgageCheckResponse> mortgageCheck(@Valid @RequestBody MortgageCheckRequest request) {
        return ResponseEntity.ok(mortgageService.performMortgageCheck(request));
    }
}