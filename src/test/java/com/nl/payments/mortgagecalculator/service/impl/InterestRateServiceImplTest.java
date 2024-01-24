package com.nl.payments.mortgagecalculator.service.impl;

import com.nl.payments.mortgagecalculator.exception.InterestRateNotFoundException;
import com.nl.payments.mortgagecalculator.model.InterestRate;
import com.nl.payments.mortgagecalculator.repository.InterestRateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.nl.payments.mortgagecalculator.enums.ErrorMessage.INTEREST_RATE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {InterestRateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InterestRateServiceImplTest {
    @MockBean
    private InterestRateRepository interestRateRepository;

    @Autowired
    private InterestRateServiceImpl interestRateServiceImpl;

    /**
     * Method under test: {@link InterestRateServiceImpl#getCurrentInterestRates()}
     */
    @Test
    @DisplayName("Given no interest rates should return empty list")
    void testGetCurrentInterestRates() {
        ArrayList<InterestRate> interestRateList = new ArrayList<>();
        when(interestRateRepository.getAllInterestRate()).thenReturn(interestRateList);
        List<InterestRate> actualCurrentInterestRates = interestRateServiceImpl.getCurrentInterestRates();
        
        verify(interestRateRepository).getAllInterestRate();
        assertTrue(actualCurrentInterestRates.isEmpty());
        assertSame(interestRateList, actualCurrentInterestRates);
    }

    /**
     * Method under test:
     * {@link InterestRateServiceImpl#getInterestRateByMaturityPeriod(int)}
     */
    @Test
    @DisplayName("Given maturity period should return interest rate")
    void testGetInterestRateByMaturityPeriod() {
        when(interestRateRepository.getInterestRateByMaturityPeriod(anyInt()))
                .thenReturn(new InterestRate(1, 4.5, mock(Timestamp.class)));

        double actualInterestRateByMaturityPeriod = interestRateServiceImpl.getInterestRateByMaturityPeriod(1);
        
        verify(interestRateRepository).getInterestRateByMaturityPeriod(anyInt());
        assertEquals(4.5, actualInterestRateByMaturityPeriod);
    }

    /**
     * Method under test:
     * {@link InterestRateServiceImpl#getInterestRateByMaturityPeriod(int)}
     */
    @Test
    @DisplayName("Given maturity period should return interest rate")
    void testGetInterestRateByMaturityPeriod2() {

        InterestRate interestRate = mock(InterestRate.class);
        when(interestRate.getInterestRatePercentage()).thenReturn(4.5);
        when(interestRateRepository.getInterestRateByMaturityPeriod(anyInt())).thenReturn(interestRate);
        double actualInterestRateByMaturityPeriod = interestRateServiceImpl.getInterestRateByMaturityPeriod(1);
        verify(interestRate).getInterestRatePercentage();
        verify(interestRateRepository).getInterestRateByMaturityPeriod(anyInt());
        assertEquals(4.5, actualInterestRateByMaturityPeriod);
    }

    /**
     * Method under test:
     * {@link InterestRateServiceImpl#getInterestRateByMaturityPeriod(int)}
     */
    @Test
    @DisplayName("Given maturity period Zero should return exception")
    void testGetInterestRateByMaturityPeriod3() {
        assertThrows(NegativeArraySizeException.class, () -> interestRateServiceImpl.getInterestRateByMaturityPeriod(0));
    }

    /**
     * Method under test:
     * {@link InterestRateServiceImpl#getInterestRateByMaturityPeriod(int)}
     */
    @Test
    @DisplayName("Given maturity period should return exception")
    void testGetInterestRateByMaturityPeriod4() {
        InterestRate interestRate = mock(InterestRate.class);
        when(interestRate.getInterestRatePercentage()).thenThrow(new IndexOutOfBoundsException(INTEREST_RATE_NOT_FOUND));
        when(interestRateRepository.getInterestRateByMaturityPeriod(anyInt())).thenReturn(interestRate);
        assertThrows(InterestRateNotFoundException.class, () -> interestRateServiceImpl.getInterestRateByMaturityPeriod(1));
        verify(interestRate).getInterestRatePercentage();
        verify(interestRateRepository).getInterestRateByMaturityPeriod(anyInt());
    }
}
