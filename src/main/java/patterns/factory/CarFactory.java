package patterns.factory;

public class CarFactory {

    private static final CarFactory INSTANCE = new CarFactory();

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return INSTANCE;
    }

    public Car create() {
        System.out.println("a new car created ...");
        return new Car();
    }
}
