package com.nl.payments.mortgagecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Mohit
 * Type ErrorDetails holds the error details.
 */
@Data
@AllArgsConstructor
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
}
