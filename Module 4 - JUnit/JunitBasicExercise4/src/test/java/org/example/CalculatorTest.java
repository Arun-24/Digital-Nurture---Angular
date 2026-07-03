package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {

        System.out.println("Setup Method Executed");

        calculator = new Calculator();
    }
    @AfterEach
    void tearDown() {

        System.out.println("Teardown Method Executed");

        calculator = null;
    }
    @Test
    void testAdd() {
        int a = 10;
        int b = 20;
        int result = calculator.add(a, b);
        assertEquals(30, result);
    }
}