package abstractFactory;

public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
