package proxy;

import java.util.Random;

/**
 * 问题：记录坦克开了多少秒
 */
public class TankB implements Movable{

    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {

        System.out.println("Tank moving claclacla ... ... ");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

//        new TankB().move();
        new TankTimeProxy(new TankB()).move();
    }
}

class TankTimeProxy implements Movable{
    TankB tank;
    public TankTimeProxy(TankB tank){
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("Moving time : " + (end - start));

    }
}
