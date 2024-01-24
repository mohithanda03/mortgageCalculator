package com.nl.payments.mortgagecalculator.constants;

import lombok.experimental.UtilityClass;

/**
 * @author Mohit
 * Type ErrorMessage class. Exposes constant error messages.
 */
@UtilityClass
public class ErrorMessage {
    public static final String MATURITY_PERIOD_IS_ZERO = "Maturity period cannot be 0. No interest rate found for maturity period.";
    public static final String INTEREST_RATE_NOT_FOUND = "No interest rate found for maturity period";

}