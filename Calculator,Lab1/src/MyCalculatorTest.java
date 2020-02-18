import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        MyCalculator calc = new MyCalculator();
            assertEquals(-1, calc.add(-1,0));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        MyCalculator calc = new MyCalculator();
        try {
            float output = calc.divide(6, -1);
            assertEquals(-6, output);
        }catch (RuntimeException e) {
            System.out.println("ERROR: division by zero");
        }
    }
}
