package com.nl.banking.mortgage.mortgagecalculator.resource;

import com.example.mortgage.calculator.model.InterestRate;
import com.example.mortgage.calculator.model.MortgageCheckRequest;
import com.example.mortgage.calculator.model.MortgageCheckResponse;
import com.example.mortgage.calculator.service.InterestRateService;
import com.example.mortgage.calculator.service.MortgageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Mohit
 * Type Mortgage Controller Exposes interestRate Endpoints.
 */
@Tag(name="Recipe API", description = "Recipe management APIs")
@RestController
@RequestMapping("/mortgage")
public class MortgageController {

    @Autowired
    private InterestRateService interestRateService;

    @Autowired
    private MortgageService mortgageService;

    @GetMapping("/interest-rates")
    public List<InterestRate> getInterestRates() {
        return interestRateService.getCurrentInterestRates();
    }

    @PostMapping("/mortgage-check")
    public MortgageCheckResponse performMortgageCheck(@Validated @RequestBody MortgageCheckRequest request) {
        return mortgageService.performMortgageCheck(request);
    }
}
