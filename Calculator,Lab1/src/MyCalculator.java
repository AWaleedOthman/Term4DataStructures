public class MyCalculator implements ICalculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public float divide(int x, int y) throws RuntimeException {
        return (float) x / y;
    }
}
