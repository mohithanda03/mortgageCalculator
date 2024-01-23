package com.nl.payments.mortgagecalculator.service;

import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.impl.MortgageServiceImpl;
import lombok.Data;
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
        when(interestRateService.getInterestRateByMaturityPeriod(anyInt())).thenReturn(10.0);

        // Act
        MortgageCheckResponse actualPerformMortgageCheckResult = mortgageServiceImpl
                .performMortgageCheck(new MortgageCheckRequest(100000.00, 20, 300000.00, 1000000.00));

        // Assert
        verify(interestRateService).getInterestRateByMaturityPeriod(anyInt());
        assertEquals(BigDecimal.valueOf(2895.06), actualPerformMortgageCheckResult.getMonthlyCosts());
        assertTrue(actualPerformMortgageCheckResult.isFeasible());
    }

    /**
     * Method under test:
     * {@link MortgageServiceImpl#performMortgageCheck(MortgageCheckRequest)}
     */
    @Test
    @DisplayName("Given mortgageCheckRequest should return feasibility false")
    void testPerformMortgageCheck2() {
        // Arrange
        when(interestRateService.getInterestRateByMaturityPeriod(anyInt())).thenReturn(3.5);

        // Act
        MortgageCheckResponse actualPerformMortgageCheckResult = mortgageServiceImpl
                .performMortgageCheck(new MortgageCheckRequest(65000.00, 10, 400000.00, 600000.00));

        // Assert
        verify(interestRateService).getInterestRateByMaturityPeriod(anyInt());
        assertEquals(BigDecimal.valueOf(3955.43), actualPerformMortgageCheckResult.getMonthlyCosts());
        assertFalse(actualPerformMortgageCheckResult.isFeasible());
    }

    /**
     * Method under test:
     * {@link MortgageServiceImpl#performMortgageCheck(MortgageCheckRequest)}
     */
    @Test
    void testPerformMortgageCheck3() {
        // Arrange
        when(interestRateService.getInterestRateByMaturityPeriod(anyInt())).thenReturn(4.0);

        // Act
        MortgageCheckResponse actualPerformMortgageCheckResult = mortgageServiceImpl
                .performMortgageCheck(new MortgageCheckRequest(65000.00, 25, 500000.00, 100000.00));

        // Assert
        verify(interestRateService).getInterestRateByMaturityPeriod(anyInt());
        assertEquals(2639, actualPerformMortgageCheckResult.getMonthlyCosts().toBigInteger().intValue());
        assertFalse(actualPerformMortgageCheckResult.isFeasible());
    }
}
