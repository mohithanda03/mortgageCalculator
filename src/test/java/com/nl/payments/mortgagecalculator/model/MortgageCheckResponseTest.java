package com.nl.payments.mortgagecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MortgageCheckResponseTest {
    /**
     * Method under test:
     * {@link MortgageCheckResponse#MortgageCheckResponse(boolean, BigDecimal)}
     */
    @Test
    @DisplayName("Calling newMortgageCheckResponse() should return new mortgage check response")
    void testNewMortgageCheckResponse() {
        MortgageCheckResponse actualMortgageCheckResponse = new MortgageCheckResponse(true, BigDecimal.valueOf(112233));

        assertEquals(BigDecimal.valueOf(112233), actualMortgageCheckResponse.getMonthlyCosts());
        assertTrue(actualMortgageCheckResponse.isFeasible());
    }
}
