package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.exception.InterestRateNotFoundException;
import com.nl.payments.mortgagecalculator.model.InterestRate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {InterestRateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InterestRateServiceImplTest {
    @Autowired
    private InterestRateServiceImpl interestRateServiceImpl;

    /**
     * Method under test: {@link InterestRateServiceImpl#getCurrentInterestRates()}
     */
    @Test
    @DisplayName("Calling getCurrentInterestRates() should return list of current interest rates")
    void testGetCurrentInterestRates() {
        // Arrange and Act
        List<InterestRate> actualCurrentInterestRates = (new InterestRateServiceImpl()).getCurrentInterestRates();

        // Assert
        assertEquals(25, actualCurrentInterestRates.size());
        InterestRate getResult = actualCurrentInterestRates.get(0);
        assertEquals(1, getResult.getMaturityPeriod());
    }

    /**
     * Method under test:
     * {@link InterestRateServiceImpl#getInterestRateByMaturityPeriod(int)}
     */
    @Test
    @DisplayName("Given maturity period should return interest rate")
    void testGetInterestRateByMaturityPeriod() {
        // Arrange, Act and Assert
        assertEquals(4.5, interestRateServiceImpl.getInterestRateByMaturityPeriod(1));
        assertThrows(NegativeArraySizeException.class, () -> interestRateServiceImpl.getInterestRateByMaturityPeriod(0));
        assertThrows(InterestRateNotFoundException.class,
                () -> interestRateServiceImpl.getInterestRateByMaturityPeriod(-1));
    }
}
