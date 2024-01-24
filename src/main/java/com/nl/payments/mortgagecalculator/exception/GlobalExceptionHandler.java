package com.nl.payments.mortgagecalculator.exception;

import com.nl.payments.mortgagecalculator.model.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;

/**
 * @author Mohit
 * Type GlobalExceptionHandler helps in returning the custom mesages in case of exceptions to users.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle InterestRateNotFoundException and return ResponseEntity with ErrorDetails
     *
     * @param exception  the InterestRateNotFoundException
     * @param webRequest the WebRequest
     * @return the ResponseEntity with ErrorDetails
     */
    @ExceptionHandler({InterestRateNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleInterestRateException(InterestRateNotFoundException exception,
                                                                    WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        log.error(exception.getMessage(), errorDetails.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles validation exceptions and returns a ResponseEntity containing a list of error messages.
     *
     * @param exception the MethodArgumentNotValidException to be handled
     * @return a ResponseEntity containing a list of error messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                     WebRequest webRequest) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        log.error(exception.getMessage(), errors);
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles global exceptions and returns an error response.
     *
     * @param exception  the exception eo be handled
     * @param webRequest the web request
     * @return the error details and HTTP status
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                              WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        log.error(exception.getMessage(), errorDetails.getMessage(), exception);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}