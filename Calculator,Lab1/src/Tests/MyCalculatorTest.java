package Tests;

import Classes.MyCalculator;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        MyCalculator calc = new MyCalculator();
        assertEquals(-1, calc.add(-1, 0));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        MyCalculator calc = new MyCalculator();
        try {
            assertEquals(-6, calc.divide(6, -1));
            assertEquals(2.5, calc.divide(5, 2));
            assertEquals(0.33, round( calc.divide(1, 3) * 100) / 100.0);
            assertEquals(0, calc.divide(5, 0));
        } catch (RuntimeException e) {
            System.out.println("ERROR: division by zero");
        }
    }
}
