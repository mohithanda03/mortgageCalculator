package com.nl.payments.mortgagecalculator.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.nl.payments.mortgagecalculator.constants.ErrorMessage.INTEREST_RATE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {InterestRateNotFoundException.class, String.class})
@ExtendWith(SpringExtension.class)
class InterestRateNotFoundExceptionTest {
    @Test
    @DisplayName("Calling newInterestRateNotFoundException() should return new INTEREST_RATE_NOT_FOUND exception")
    void testNewInterestRateNotFoundException() {
        InterestRateNotFoundException actualInterestRateNotFoundException = new InterestRateNotFoundException(
                INTEREST_RATE_NOT_FOUND);

        assertEquals("No interest rate found for maturity period", actualInterestRateNotFoundException.getLocalizedMessage());
        assertEquals("No interest rate found for maturity period", actualInterestRateNotFoundException.getMessage());
        assertNull(actualInterestRateNotFoundException.getCause());
        assertEquals(0, actualInterestRateNotFoundException.getSuppressed().length);
    }
}
