package com.nl.payments.mortgagecalculator.utils;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.nl.payments.mortgagecalculator.utils.CalcUtil.toDecimalFormat;
import static org.junit.jupiter.api.Assertions.*;

class CalcUtilTest {

    @Test
    @DisplayName("Given mortgageCheckRequest and interestRate should return monthly costs")
    void testCalculateMonthlyCosts() {
        assertEquals(BigDecimal.valueOf(1787.21),
                CalcUtil.calculateMonthlyCosts(new MortgageCheckRequest(95000.0, 15, 250000.0, 300000.0), 3.5));
    }

    @Test
    @DisplayName("Given mortgageCheckRequest should return true if it is feasible")
    void testIsFeasible() {
        assertFalse(CalcUtil.isFeasible(new MortgageCheckRequest(50000.0, 10, 100000.0, 60000.0)));
        assertTrue(CalcUtil.isFeasible(new MortgageCheckRequest(95000.0, 20, 300000.0, 600000.0)));
        assertFalse(CalcUtil.isFeasible(new MortgageCheckRequest(250000.0, 5, 40000.0, 10000.0)));
    }

    @Test
    @DisplayName("Given Monthly Costs should return formatted to 2 decimal places")
    void testToDecimalFormat() {
        BigDecimal actualToDecimalFormatResult = toDecimalFormat(new BigDecimal("2300.00"));
        assertEquals(new BigDecimal("2300.00"), actualToDecimalFormatResult);
    }

    @Test
    @DisplayName("Given zero monthly costs should return formatted to 2 decimal places")
    void testFormatDecimalZero() {
        BigDecimal actualFormatDecimalResult = toDecimalFormat(BigDecimal.ZERO);
        assertEquals(new BigDecimal("0.00"), actualFormatDecimalResult);
    }

     @Test
     @DisplayName("Given null monthly costs should throw NullPointerException")
     void testFormatDecimalNull() {
         assertThrows(NullPointerException.class, () -> toDecimalFormat(null));

        }
}