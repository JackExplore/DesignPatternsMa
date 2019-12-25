package patterns.abstractFactory;

public class Main {

    public static void main(String[] args) {

        AbstractFactory factory = new ModernFactory();

        Food f = factory.createFood();
        f.printName();
        Vehicle v = factory.createVehicle();
        v.go();
        Weapon w = factory.createWeapon();
        w.shoot();
    }
}
