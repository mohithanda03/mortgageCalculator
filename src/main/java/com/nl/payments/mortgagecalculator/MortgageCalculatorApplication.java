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
@SpringBootApplication(scanBasePackages = "com.nl.payments.mortgagecalculator")
public class MortgageCalculatorApplication {
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