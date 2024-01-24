package com.nl.payments.mortgagecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCheckRequestTest {
    @Test
    void testMortgageCheckRequest() {
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(10000.00, 7, 50000.00, 100000.00);
        assertTrue(mortgageCheckRequest.canEqual(new MortgageCheckRequest(10000.00, 7, 50000.00, 100000.00)));
    }

    @Test
    void testMortgageCheckRequestwithNull() {

        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(null, null, null, null);

        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    @Test
    @DisplayName("Calling getters and setters should return new mortgage check request")
    void testGettersAndSetters() {
        MortgageCheckRequest actualMortgageCheckRequest = new MortgageCheckRequest(65000.0, 13, 90000.0, 99000.0);
        actualMortgageCheckRequest.setHomeValue(99000.0);
        actualMortgageCheckRequest.setIncome(65000.0);
        actualMortgageCheckRequest.setLoanValue(90000.0);
        actualMortgageCheckRequest.setMaturityPeriod(13);
        String actualToStringResult = actualMortgageCheckRequest.toString();
        Double actualHomeValue = actualMortgageCheckRequest.getHomeValue();
        Double actualIncome = actualMortgageCheckRequest.getIncome();
        Double actualLoanValue = actualMortgageCheckRequest.getLoanValue();

        assertEquals("MortgageCheckRequest(income=65000.0, maturityPeriod=13, loanValue=90000.0, homeValue=99000.0)",
                actualToStringResult);
        assertEquals(13, actualMortgageCheckRequest.getMaturityPeriod().intValue());
        assertEquals(99000.0, actualHomeValue.doubleValue());
        assertEquals(65000.0, actualIncome.doubleValue());
        assertEquals(90000.0, actualLoanValue.doubleValue());
    }

    @Test
    @DisplayName("Calling newMortgageCheckRequest() should return new mortgage check request")
    void testNewMortgageCheckRequest() {
        MortgageCheckRequest actualMortgageCheckRequest = new MortgageCheckRequest(10000.0, 10, 50000.0, 100000.0);
        assertEquals(10, actualMortgageCheckRequest.getMaturityPeriod());
        assertEquals(100000, actualMortgageCheckRequest.getHomeValue());
        assertEquals(10000, actualMortgageCheckRequest.getIncome());
        assertEquals(50000, actualMortgageCheckRequest.getLoanValue());
    }
}
