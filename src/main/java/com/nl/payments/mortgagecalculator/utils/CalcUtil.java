package com.nl.payments.mortgagecalculator.utils;

import com.nl.payments.mortgagecalculator.constants.MortgageConstants;
import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.nl.payments.mortgagecalculator.constants.MortgageConstants.MONTHS_IN_A_YEAR;
import static com.nl.payments.mortgagecalculator.constants.MortgageConstants.PERCENTAGE;
import static java.math.RoundingMode.HALF_UP;

/**
 * @author Mohit
 * Type CalcUtil  implements the utility methods.
 */
@Component
public class CalcUtil {

    /**
     * Calculates the monthly costs of a mortgage based on the given MortgageCheckRequest and interest rate.
     *
     * @param request      the MortgageCheckRequest containing loan value and maturity period
     * @param interestRate the annual interest rate
     * @return the calculated monthly payment
     */
    public static BigDecimal calculateMonthlyCosts(MortgageCheckRequest request, double interestRate) {
        double monthlyInterestPercent = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        int totalNbOfPayments = request.getMaturityPeriod() * MONTHS_IN_A_YEAR;
        BigDecimal monthlyPayment;
        monthlyPayment = BigDecimal.valueOf(request.getLoanValue() * (
                (monthlyInterestPercent * (Math.pow(1 + monthlyInterestPercent, totalNbOfPayments))) /
                        (Math.pow(1 + monthlyInterestPercent, totalNbOfPayments) - 1)
        ));
        return toDecimalFormat(monthlyPayment);
    }

    /**
     * Check if the mortgage is feasible based on the loan value, income, and home value.
     *
     * @param request the mortgage check request containing loan value, income, and home value
     * @return true if the mortgage is feasible, false otherwise
     */
    public static Boolean isFeasible(MortgageCheckRequest request) {

        return request.getLoanValue() <= request.getIncome() * MortgageConstants.MAXIMUM_TIMES_INCOME &&
                request.getLoanValue() <= request.getHomeValue();
    }

    /**
     * Converts the given BigDecimal value to a decimal format with two decimal places.
     *
     * @param val the BigDecimal value to be converted
     * @return the BigDecimal value in decimal format with two decimal places
     */
    public static BigDecimal toDecimalFormat(@NotNull BigDecimal val) {
        return val.setScale(2, HALF_UP);
    }
}

