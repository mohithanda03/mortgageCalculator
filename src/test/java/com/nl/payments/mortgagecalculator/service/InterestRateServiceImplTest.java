package com.nl.payments.mortgagecalculator.service;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.service.impl.InterestRateServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {InterestRateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InterestRateServiceImplTest {
    @Autowired
    private InterestRateServiceImpl interestRateServiceImpl;

    /**
     * Method under test: {@link InterestRateServiceImpl#getCurrentInterestRates()}
     */
    @Test
    @DisplayName("Given interest rates should return current interest rates")
    void testGetCurrentInterestRates() {
        // Arrange and Act
        List<InterestRate> actualCurrentInterestRates = (new InterestRateServiceImpl()).getCurrentInterestRates();

        // Assert
        assertEquals(25, actualCurrentInterestRates.size());
        InterestRate getResult = actualCurrentInterestRates.get(0);
        assertEquals(1, getResult.getMaturityPeriod());
        InterestRate getResult2 = actualCurrentInterestRates.get(9);
        assertEquals(10, getResult2.getMaturityPeriod());
        InterestRate getResult3 = actualCurrentInterestRates.get(10);
        assertEquals(11, getResult3.getMaturityPeriod());
        InterestRate getResult4 = actualCurrentInterestRates.get(11);
        assertEquals(12, getResult4.getMaturityPeriod());
        InterestRate getResult5 = actualCurrentInterestRates.get(12);
        assertEquals(13, getResult5.getMaturityPeriod());
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
    }
}
