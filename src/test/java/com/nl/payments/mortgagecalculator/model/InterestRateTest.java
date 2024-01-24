package com.nl.payments.mortgagecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

class InterestRateTest {

    @Test
    @DisplayName("Calling newInterestRate() should return new interest rate")
    void testNewInterestRate() {
        Timestamp lastUpdate = mock(Timestamp.class);
        InterestRate actualInterestRate = new InterestRate(1, 9000.0, lastUpdate);

        assertEquals(1, actualInterestRate.getMaturityPeriod());
        assertEquals(9000.0, actualInterestRate.getInterestRatePercentage());
        assertSame(lastUpdate, actualInterestRate.getLastUpdate());
    }
}
