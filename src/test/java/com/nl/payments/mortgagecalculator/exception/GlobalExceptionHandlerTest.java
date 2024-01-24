package com.nl.payments.mortgagecalculator.exception;

import com.nl.payments.mortgagecalculator.model.ErrorDetails;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import static com.nl.payments.mortgagecalculator.constants.ErrorMessage.INTEREST_RATE_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {GlobalExceptionHandler.class})
@ExtendWith(SpringExtension.class)
class GlobalExceptionHandlerTest {
  @Autowired
  private GlobalExceptionHandler globalExceptionHandler;

  @Test
  @DisplayName("Given interest rate not found exception should return error details")
  void testHandleInterestRateException() {
    InterestRateNotFoundException exception = new InterestRateNotFoundException(INTEREST_RATE_NOT_FOUND);

    ResponseEntity<ErrorDetails> actualHandleInterestRateExceptionResult = globalExceptionHandler
            .handleInterestRateException(exception, new ServletWebRequest(new MockHttpServletRequest()));

    ErrorDetails body = actualHandleInterestRateExceptionResult.getBody();
      assert body != null;
      assertEquals("No interest rate found for maturity period", body.getMessage());
    assertEquals("uri=", body.getDetails());
    assertEquals(404, actualHandleInterestRateExceptionResult.getStatusCodeValue());
    assertTrue(actualHandleInterestRateExceptionResult.hasBody());
    assertTrue(actualHandleInterestRateExceptionResult.getHeaders().isEmpty());
  }

  @Test
  @DisplayName("Given invalid mortgage details exception should return error details")
  void testHandleMethodArgumentNotValid() {
    MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
    when(exception.getMessage()).thenReturn("An error occurred");
    when(exception.getBindingResult()).thenReturn(new BindException("Target", "Object Name"));

    ResponseEntity<List<String>> actualHandleMethodArgumentNotValidResult = globalExceptionHandler
            .handleMethodArgumentNotValid(exception, new ServletWebRequest(new MockHttpServletRequest()));
    verify(exception).getBindingResult();
    verify(exception).getMessage();
    assertEquals(400, actualHandleMethodArgumentNotValidResult.getStatusCodeValue());
    assertTrue(actualHandleMethodArgumentNotValidResult.hasBody());
    assertTrue(actualHandleMethodArgumentNotValidResult.getHeaders().isEmpty());
  }

  @Test
  @DisplayName("Given global exception should return error details")
  void testHandleGlobalException() {
    Exception exception = new Exception("An error occurred");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getRequestURI()).thenReturn("https://mortgage/mortgage");

    ResponseEntity<ErrorDetails> actualHandleGlobalExceptionResult = globalExceptionHandler
            .handleGlobalException(exception, new ServletWebRequest(request));
    verify(request).getRequestURI();
    ErrorDetails body = actualHandleGlobalExceptionResult.getBody();
      assert body != null;
      assertEquals("An error occurred", body.getMessage());
    assertEquals("uri=https://mortgage/mortgage", body.getDetails());
    assertEquals(500, actualHandleGlobalExceptionResult.getStatusCodeValue());
    assertTrue(actualHandleGlobalExceptionResult.hasBody());
    assertTrue(actualHandleGlobalExceptionResult.getHeaders().isEmpty());
  }
}