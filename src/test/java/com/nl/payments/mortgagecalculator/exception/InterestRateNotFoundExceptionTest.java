package com.nl.payments.mortgagecalculator.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.nl.payments.mortgagecalculator.enums.ErrorMessage.INTEREST_RATE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = {InterestRateNotFoundException.class, String.class})
@ExtendWith(SpringExtension.class)
class InterestRateNotFoundExceptionTest {
    /**
     * Method under test:
     * {@link InterestRateNotFoundException#InterestRateNotFoundException(String)}
     */
    @Test
    @DisplayName("Calling newInterestRateNotFoundException() should return new interest rate not found exception")
    void testNewInterestRateNotFoundException() {
        InterestRateNotFoundException actualInterestRateNotFoundException = new InterestRateNotFoundException(
                INTEREST_RATE_NOT_FOUND);

        assertEquals("No interest rate found for maturity period", actualInterestRateNotFoundException.getLocalizedMessage());
        assertEquals("No interest rate found for maturity period", actualInterestRateNotFoundException.getMessage());
        assertNull(actualInterestRateNotFoundException.getCause());
        assertEquals(0, actualInterestRateNotFoundException.getSuppressed().length);
    }
}
