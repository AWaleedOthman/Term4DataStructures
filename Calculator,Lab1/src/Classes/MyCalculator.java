package Classes;

import Interfaces.ICalculator;

public class MyCalculator implements ICalculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public float divide(int x, int y) throws RuntimeException {
        if (y == 0) {
            throw new RuntimeException();
        } else {
            return (float) x / y;
        }
    }
}
