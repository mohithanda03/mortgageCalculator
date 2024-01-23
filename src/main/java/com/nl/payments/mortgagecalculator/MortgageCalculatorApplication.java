package com.nl.payments.mortgagecalculator;

import com.nl.payments.mortgagecalculator.model.InterestRate;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohit
 * Type MortgageCalculatorApplication calculates feasibility and monthly cost based on the provided morgage details.
 */
@Slf4j
@SpringBootApplication
public class MortgageCalculatorApplication {

    public static final List<InterestRate> INTEREST_RATES = new ArrayList<>();

    static {
        INTEREST_RATES.add(new InterestRate(1, 4.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(2, 4.4, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(3, 4.3, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(4, 4.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(5, 4.1, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(6, 4.0, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(7, 3.9, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(8, 3.8, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(9, 3.7, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(10, 3.6, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(11, 3.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(12, 3.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(13, 3.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(14, 3.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(15, 3.5, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(16, 3.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(17, 3.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(18, 3.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(19, 3.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(20, 3.2, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(21, 3.0, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(22, 3.0, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(23, 3.0, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(24, 3.0, Timestamp.from(Instant.now())));
        INTEREST_RATES.add(new InterestRate(25, 3.0, Timestamp.from(Instant.now())));

        log.info("{} Interest Rates loaded successfully ", INTEREST_RATES.size());
    }

    /**
     * The main method for starting the MortgageCalculatorApplication.
     *
     * @param args an array of command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MortgageCalculatorApplication.class, args);
    }


    /**
     * A method annotated with @PostConstruct to initialize the application.
     */
    @PostConstruct
    public void init() {
        log.info("Application started successfully at {}", Timestamp.from(Instant.now()));
    }

    /**
     * Method called by the container upon destruction of the bean instance.
     */
    @PreDestroy
    public void destroy() {
        log.info("Application stopped at {}", Timestamp.from(Instant.now()));
    }
}
