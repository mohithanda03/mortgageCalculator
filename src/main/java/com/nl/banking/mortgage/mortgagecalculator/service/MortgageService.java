package com.nl.banking.mortgage.mortgagecalculator.service;

import com.example.mortgage.calculator.model.MortgageCheckRequest;
import com.example.mortgage.calculator.model.MortgageCheckResponse;
import org.springframework.stereotype.Service;

@Service
public interface MortgageService {

    MortgageCheckResponse performMortgageCheck(MortgageCheckRequest request);

}

