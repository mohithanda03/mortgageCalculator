package com.nl.payments.mortgagecalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * @author mohit
 * Type InterestRateNotFoundException thrown when interest rate is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InterestRateNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InterestRateNotFoundException(String message) {
        super(String.format(message));
    }
}