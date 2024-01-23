package com.nl.payments.mortgagecalculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCheckRequestTest {
    /**
     * Method under test: {@link MortgageCheckRequest#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(10000.00, 7, 50000.00, 100000.00);
        assertTrue(mortgageCheckRequest.canEqual(new MortgageCheckRequest(10000.00, 7, 50000.00, 100000.00)));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals() {
        // Arrange, Act and Assert
        assertNotEquals(new MortgageCheckRequest(10000.0, 1, 9000.0, 9000.0), null);
        assertNotEquals(new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0), "Different type to MortgageCheckRequest");
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals2() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(null, 1, 9000.0, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals3() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(50000.0, 1, 9000.0, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals4() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 3, 9000.0, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals5() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, null, 9000.0, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals6() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, null, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals7() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 0.5d, 9000.0);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals8() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 9000.0, null);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Method under test: {@link MortgageCheckRequest#equals(Object)}
     */
    @Test
    void testEquals9() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 9000.0, 0.5d);

        // Act and Assert
        assertNotEquals(mortgageCheckRequest, new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode2() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0);
        MortgageCheckRequest mortgageCheckRequest2 = new MortgageCheckRequest(9000.0, 1, 9000.0, 9000.0);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest2);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode3() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(null, 1, 9000.0, 9000.0);
        MortgageCheckRequest mortgageCheckRequest2 = new MortgageCheckRequest(null, 1, 9000.0, 9000.0);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest2);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode4() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, null, 9000.0, 9000.0);
        MortgageCheckRequest mortgageCheckRequest2 = new MortgageCheckRequest(9000.0, null, 9000.0, 9000.0);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest2);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode5() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, null, 9000.0);
        MortgageCheckRequest mortgageCheckRequest2 = new MortgageCheckRequest(9000.0, 1, null, 9000.0);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest2);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link MortgageCheckRequest#equals(Object)}
     *   <li>{@link MortgageCheckRequest#hashCode()}
     * </ul>
     */
    @Test
    void testEqualsAndHashCode6() {
        // Arrange
        MortgageCheckRequest mortgageCheckRequest = new MortgageCheckRequest(9000.0, 1, 5000.0, null);
        MortgageCheckRequest mortgageCheckRequest2 = new MortgageCheckRequest(9000.0, 1, 5000.0, null);

        // Act and Assert
        assertEquals(mortgageCheckRequest, mortgageCheckRequest2);
        int expectedHashCodeResult = mortgageCheckRequest.hashCode();
        assertEquals(expectedHashCodeResult, mortgageCheckRequest2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link MortgageCheckRequest#MortgageCheckRequest(Double, Integer, Double, Double)}
     *   <li>{@link MortgageCheckRequest#setHomeValue(Double)}
     *   <li>{@link MortgageCheckRequest#setIncome(Double)}
     *   <li>{@link MortgageCheckRequest#setLoanValue(Double)}
     *   <li>{@link MortgageCheckRequest#setMaturityPeriod(Integer)}
     *   <li>{@link MortgageCheckRequest#toString()}
     *   <li>{@link MortgageCheckRequest#getHomeValue()}
     *   <li>{@link MortgageCheckRequest#getIncome()}
     *   <li>{@link MortgageCheckRequest#getLoanValue()}
     *   <li>{@link MortgageCheckRequest#getMaturityPeriod()}
     * </ul>
     */
    @Test
    @DisplayName("Calling getters and setters should return new mortgage check request")
    void testGettersAndSetters() {
        // Arrange and Act
        MortgageCheckRequest actualMortgageCheckRequest = new MortgageCheckRequest(65000.0, 13, 90000.0, 99000.0);
        actualMortgageCheckRequest.setHomeValue(99000.0);
        actualMortgageCheckRequest.setIncome(65000.0);
        actualMortgageCheckRequest.setLoanValue(90000.0);
        actualMortgageCheckRequest.setMaturityPeriod(13);
        String actualToStringResult = actualMortgageCheckRequest.toString();
        Double actualHomeValue = actualMortgageCheckRequest.getHomeValue();
        Double actualIncome = actualMortgageCheckRequest.getIncome();
        Double actualLoanValue = actualMortgageCheckRequest.getLoanValue();

        // Assert that nothing has changed
        assertEquals("MortgageCheckRequest(income=65000.0, maturityPeriod=13, loanValue=90000.0, homeValue=99000.0)",
                actualToStringResult);
        assertEquals(13, actualMortgageCheckRequest.getMaturityPeriod().intValue());
        assertEquals(99000.0, actualHomeValue.doubleValue());
        assertEquals(65000.0, actualIncome.doubleValue());
        assertEquals(90000.0, actualLoanValue.doubleValue());
    }

    /**
     * Method under test: {@link MortgageCheckRequest(double, int, double, double)}
     */
    @Test
    @DisplayName("Calling newMortgageCheckRequest() should return new mortgage check request")
    void testNewMortgageCheckRequest() {
        MortgageCheckRequest actualMortgageCheckRequest = new MortgageCheckRequest(10000.0, 10, 50000.0, 100000.0);

        assertEquals(10, actualMortgageCheckRequest.getMaturityPeriod());
        assertEquals(100000, actualMortgageCheckRequest.getHomeValue());
        assertEquals(10000, actualMortgageCheckRequest.getIncome());
        assertEquals(50000, actualMortgageCheckRequest.getLoanValue());
    }
}
