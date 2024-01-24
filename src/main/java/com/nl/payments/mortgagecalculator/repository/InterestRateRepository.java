package com.nl.payments.mortgagecalculator.repository;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class InterestRateRepository {

    /**
     * @author Mohit
     * Type InterestRateRepository provides the list of interest rates.
     */
    private final List<InterestRate> interestRates = new ArrayList<>();

    public InterestRateRepository(){
        interestRates.add(new InterestRate(1, 4.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(2, 4.4, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(3, 4.3, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(4, 4.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(5, 4.1, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(6, 4.0, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(7, 3.9, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(8, 3.8, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(9, 3.7, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(10, 3.6, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(11, 3.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(12, 3.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(13, 3.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(14, 3.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(15, 3.5, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(16, 3.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(17, 3.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(18, 3.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(19, 3.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(20, 3.2, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(21, 3.0, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(22, 3.0, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(23, 3.0, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(24, 3.0, Timestamp.from(Instant.now())));
        interestRates.add(new InterestRate(25, 3.0, Timestamp.from(Instant.now())));

        log.info("{} Interest Rates loaded successfully ", interestRates.size());
    }

    /**
     * Retrieves the interest rate for a given maturity period.
     *
     * @param  maturityPeriod  maturity period for which interest rate is required
     * @return                 interest rate for the specified maturity period
     */
    public InterestRate getInterestRateByMaturityPeriod(@NotNull int maturityPeriod) {
        return interestRates.get(maturityPeriod);
    }

    /**
     * Retrieves the current interest rates.
     *
     * @return  a list of current interest rates
     */
    public List<InterestRate> getAllInterestRate() {
        return  interestRates;
    }
}
