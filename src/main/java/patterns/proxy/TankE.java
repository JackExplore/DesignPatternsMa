package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;


/**
 * 使用 JDK 的动态代理
 * 内部类
 */
public class TankE implements Movable {
    @Override
    public void move() {
        System.out.println("TankE moving calclacla ......");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TankE tankE = new TankE();

        // reflection - 通过字节码分析类的属性和方法，动态代理
        Movable m = (Movable) Proxy.newProxyInstance(TankE.class.getClassLoader(), // ClassLoader() 类的加载器
                new Class[]{Movable.class},     // 实现的接口数组
                new LogHandler(tankE));

        m.move();   //
    }
}

class LogHandler implements InvocationHandler {

    TankE tankE;

    public LogHandler(TankE tankE){
        this.tankE = tankE;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("method : " + method.getName() + " start ...");
        Object o = method.invoke(tankE, args);
        System.out.println("method : " + method.getName() + " end !");
        return o;
    }
}
