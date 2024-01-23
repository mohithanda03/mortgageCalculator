package com.nl.payments.mortgagecalculator.utils;

import com.nl.payments.mortgagecalculator.enums.Constants;
import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

import static com.nl.payments.mortgagecalculator.enums.Constants.MONTHS_IN_A_YEAR;
import static com.nl.payments.mortgagecalculator.enums.Constants.PERCENTAGE;
import static java.math.RoundingMode.HALF_UP;

public class CalcUtil {
    private CalcUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BigDecimal calculateMonthlyCosts(MortgageCheckRequest request, double interestRate) {
        double monthlyInterestPercent = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        int numberOfPayments = request.getMaturityPeriod() * MONTHS_IN_A_YEAR;
        BigDecimal monthlyPayment;
        monthlyPayment = BigDecimal.valueOf(request.getLoanValue() * (
                (monthlyInterestPercent * (Math.pow(1 + monthlyInterestPercent, numberOfPayments))) /
                        (Math.pow(1 + monthlyInterestPercent, numberOfPayments) - 1)
        ));
        return format2Decimal(monthlyPayment);
    }

    public static Boolean isFeasible(MortgageCheckRequest request) {

        return request.getLoanValue() <= request.getIncome() * Constants.MAXIMUM_TIMES_INCOME &&
                request.getLoanValue() <= request.getHomeValue();
    }

    public static BigDecimal format2Decimal(@NotNull BigDecimal val) {
        return val.setScale(2, HALF_UP);
    }
}

