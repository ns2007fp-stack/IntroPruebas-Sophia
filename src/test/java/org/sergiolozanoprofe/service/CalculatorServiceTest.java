package org.sergiolozanoprofe.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sergiolozanoprofe.model.OperationType;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeEach
    void initCalculator() {
        calculator = new CalculatorService();
    }

    @Test
    void addTwoPositiveNumbers() {
        double result = calculator.add(2, 3);
        assertEquals(5.0, result, "2 + 3 debería ser 5");
    }

    @Test
    void subtractNumbersOrderMatters() {
        double result = calculator.subtract(3, 5);
        assertEquals(-2.0, result, "3 - 5 debería ser -2");
    }

    @Test
    void multiplyByPositiveAndNegative() {
        double result = calculator.multiply(-2, 3);
        assertEquals(-6.0, result, "-2 * 3 debería ser -6");
    }

    @Test
    void divideNumbersNormally() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, "10 / 2 debería ser 5");
    }

    @Test
    void divisionByZeroShouldFail() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(5, 0),
                "División por cero debería lanzar ArithmeticException");
    }

    @Test
    void computeAllOperatorsTogether() {
        assertEquals(5.0, calculator.compute(2, OperationType.ADD, 3), "compute ADD");
        assertEquals(-1.0, calculator.compute(2, OperationType.SUBTRACT, 3), "compute SUBTRACT");
        assertEquals(6.0, calculator.compute(2, OperationType.MULTIPLY, 3), "compute MULTIPLY");
        assertEquals(2.0, calculator.compute(6, OperationType.DIVIDE, 3), "compute DIVIDE");
    }
}