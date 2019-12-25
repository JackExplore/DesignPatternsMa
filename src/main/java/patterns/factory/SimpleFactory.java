package patterns.factory;

/**
 * 简单工厂模式
 * : 可扩展性不好
 */
public class SimpleFactory {

    public Car createCar() {
        // before processing  : add  permission  logging ...
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
