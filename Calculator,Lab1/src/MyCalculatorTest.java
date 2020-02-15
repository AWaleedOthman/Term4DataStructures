import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        MyCalculator calc = new MyCalculator();
        int output = calc.add(6, -1);
        assertEquals(5, output);
    }

    @org.junit.jupiter.api.Test
    void divide() {
        MyCalculator calc = new MyCalculator();
        float output = calc.divide(6, -1);
        assertEquals(-6, output);
    }
}
