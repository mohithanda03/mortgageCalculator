package com.nl.payments.mortgagecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

class InterestRateTest {
    /**
     * Method under test: {@link InterestRate#InterestRate(int, double, Timestamp)}
     */
    @Test
    @DisplayName("Calling newInterestRate() should return new interest rate")
    void testNewInterestRate() {
        // Arrange
        Timestamp lastUpdate = mock(Timestamp.class);

        // Act
        InterestRate actualInterestRate = new InterestRate(1, 9000.0, lastUpdate);

        // Assert
        assertEquals(1, actualInterestRate.getMaturityPeriod());
        assertEquals(9000.0, actualInterestRate.getInterestRatePercentage());
        assertSame(lastUpdate, actualInterestRate.getLastUpdate());
    }
}
