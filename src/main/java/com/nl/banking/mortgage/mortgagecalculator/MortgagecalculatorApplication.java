package com.nl.banking.mortgage.mortgagecalculator;

import com.example.mortgage.calculator.model.InterestRate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MortgageCalculatorApplication {

	public static final List<InterestRate> INTEREST_RATES = new ArrayList<>();

	static {
		INTEREST_RATES.add(new InterestRate(1, 3.5, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(2, 3.2, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(3, 3.0, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(4, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(5, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(6, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(7, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(8, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(9, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(10, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(11, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(12, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(13, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(14, 2.8, Timestamp.from(Instant.now())));
		INTEREST_RATES.add(new InterestRate(15, 2.8, Timestamp.from(Instant.now())));
	}

	public static void main(String[] args) {
		SpringApplication.run(MortgageCalculatorApplication.class, args);
	}
}
