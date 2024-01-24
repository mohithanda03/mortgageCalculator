package com.nl.payments.mortgagecalculator.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mohit
 * Type MortgageCheckRequest holds the request parameters for mortgage check Request.
 */
@Data
@AllArgsConstructor
public class MortgageCheckRequest {

    @Valid
    @NotNull(message = "Income is required")
    @Positive(message = "Income should be greater than zero")
    private Double income;
    @Valid
    @NotNull(message = "MaturityPeriod is required")
    @Positive(message = "MaturityPeriod should be greater than zero")
    private Integer maturityPeriod;
    @Valid
    @NotNull(message = "LoanValue is required")
    @Positive(message = "LoanValue should be greater than zero")
    private Double loanValue;
    @Valid
    @NotNull(message = "HomeValue is required")
    @Positive(message = "HomeValue should be greater than zero")
    private Double homeValue;
}

