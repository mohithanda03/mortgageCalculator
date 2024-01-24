package com.nl.payments.mortgagecalculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantsTest {

    /**
     * Test for the number of months in a year.
     */
    @Test
    @DisplayName("Test months in a year")
    void testMonthsInAYear() {
        assertEquals(12, Constants.MONTHS_IN_A_YEAR);
    }

    /**
     * Test for the maximum times income constant.
     */
    @Test
    @DisplayName("Test maximum times income")
    void testMaximumTimesIncome() {
        assertEquals(4, Constants.MAXIMUM_TIMES_INCOME);
    }

    /**
     * Test the percentage calculation.
     */
    @Test
    @DisplayName("Test percentage")
    void testPercentage() {
        assertEquals(100, Constants.PERCENTAGE);
    }
}
