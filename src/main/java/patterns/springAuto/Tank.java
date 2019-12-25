package patterns.springAuto;

import java.util.Random;

public class Tank {

    /**
     * 模拟坦克移动了一段时间
     */
    public void move() {
        System.out.println("Spring Tank moving claclacla ... ... ");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
