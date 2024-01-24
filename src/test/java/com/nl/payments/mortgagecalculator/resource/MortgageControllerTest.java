package com.nl.payments.mortgagecalculator.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nl.payments.mortgagecalculator.model.MortgageCheckRequest;
import com.nl.payments.mortgagecalculator.model.MortgageCheckResponse;
import com.nl.payments.mortgagecalculator.service.InterestRateService;
import com.nl.payments.mortgagecalculator.service.MortgageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MortgageController.class})
@ExtendWith(SpringExtension.class)
class MortgageControllerTest {
    @MockBean
    private InterestRateService interestRateService;

    @Autowired
    private MortgageController mortgageController;

    @MockBean
    private MortgageService mortgageService;

    @Test
    @DisplayName("Calling GET /interest-rates should return list of current interest rates")
    void testGetInterestRates() throws Exception {
        when(interestRateService.getCurrentInterestRates()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mortgage/interest-rates");

        MockMvcBuilders.standaloneSetup(mortgageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    @DisplayName("Calling POST /mortgage/mortgage-check should return feasibility true")
    void testPerformMortgageCheck() throws Exception {
        when(mortgageService.performMortgageCheck(Mockito.any()))
                .thenReturn(new MortgageCheckResponse(true, new BigDecimal("1650.00")));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/mortgage/mortgage-check")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new MortgageCheckRequest(65000.0, 10, 100000.0, 500000.0)));

        MockMvcBuilders.standaloneSetup(mortgageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"feasible\":true,\"monthlyCosts\":1650.00}"));
    }
}
