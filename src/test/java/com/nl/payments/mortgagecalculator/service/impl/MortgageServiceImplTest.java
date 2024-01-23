package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {MortgageServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MortgageServiceImplTest {
    @MockBean
    private InterestRateService interestRateService;

    @Autowired
    private MortgageServiceImpl mortgageServiceImpl;

    /**
     * Method under test:
     * {@link MortgageServiceImpl#performMortgageCheck(MortgageCheckRequest)}
     */
    @Test
    @DisplayName("Given mortgageCheckRequest should return feasibility true")
    void testPerformMortgageCheck() {
        // Arrange
        when(interestRateService.getInterestRateByMaturityPeriod(anyInt())).thenReturn(3.5);

        // Act
        MortgageCheckResponse actualPerformMortgageCheckResult = mortgageServiceImpl
                .performMortgageCheck(new MortgageCheckRequest(95000.00, 20, 50000.00, 100000.00));

        // Assert
        verify(interestRateService).getInterestRateByMaturityPeriod(anyInt());
        assertTrue(actualPerformMortgageCheckResult.isFeasible());
        BigDecimal expectedMonthlyCosts = new BigDecimal("289.98");
        assertEquals(expectedMonthlyCosts, actualPerformMortgageCheckResult.getMonthlyCosts());
    }

    /**
     * Method under test:
     * {@link MortgageServiceImpl#performMortgageCheck(MortgageCheckRequest)}
     */
    @Test
    @DisplayName("Given mortgageCheckRequest should return feasibility false")
    void testPerformMortgageCheck3() {
        // Arrange
        when(interestRateService.getInterestRateByMaturityPeriod(anyInt())).thenReturn(4.5);

        // Act
        MortgageCheckResponse actualPerformMortgageCheckResult = mortgageServiceImpl
                .performMortgageCheck(new MortgageCheckRequest(65000.00, 10, 400000.00, 100000.00));

        // Assert
        verify(interestRateService).getInterestRateByMaturityPeriod(anyInt());
        assertFalse(actualPerformMortgageCheckResult.isFeasible());
        BigDecimal expectedMonthlyCosts = new BigDecimal("4145.54");
        assertEquals(expectedMonthlyCosts, actualPerformMortgageCheckResult.getMonthlyCosts());
    }
}
