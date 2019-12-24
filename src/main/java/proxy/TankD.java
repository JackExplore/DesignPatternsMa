package proxy;

import java.util.Random;

public class TankD implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving calclacla ......");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
