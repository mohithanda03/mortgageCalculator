package com.nl.payments.mortgagecalculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorMessageTest {

    /**
     * Test case for when the maturity period is zero.
     */
    @Test
    @DisplayName("Maturity period is zero")
    void testMaturityPeriodIsZero() {
        assertEquals("Maturity period cannot be 0. No interest rate found for maturity period.", ErrorMessage.MATURITY_PERIOD_IS_ZERO);
    }

    /**
     * Test case for when interest rate is not found.
     */
    @Test
    @DisplayName("Interest rate not found")
    void testInterestRateNotFound() {
        assertEquals("No interest rate found for maturity period", ErrorMessage.INTEREST_RATE_NOT_FOUND);
    }
}

