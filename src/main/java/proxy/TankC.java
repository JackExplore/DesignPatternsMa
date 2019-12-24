package proxy;

import java.util.Random;

/**
 * 静态代理模式
 */
public class TankC implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving claclacla ......");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TankLogProxlyT(new TankTimeProxyT(new TankC())).move();
        System.out.println("=========");
        new TankTimeProxyT(new TankLogProxlyT(new TankC())).move();
    }
}


class TankTimeProxyT implements Movable{
    Movable m;
    public TankTimeProxyT(Movable m){
        this.m = m;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start time : " + start);
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("end time : " + end);

        System.out.println("Moving time : " + (end - start));
    }
}
class TankLogProxlyT implements Movable{
    Movable m;
    public TankLogProxlyT(Movable m){
        this.m = m;
    }
    @Override
    public void move() {
        System.out.println("log begin ...");
        m.move();
        System.out.println("log OK!");
    }
}