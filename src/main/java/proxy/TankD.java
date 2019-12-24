package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;


/**
 * 使用 JDK 的动态代理
 */
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

    public static void main(String[] args) {

        TankD tankD = new TankD();


        // reflection - 通过字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(TankD.class.getClassLoader(),
                new Class[]{Movable.class},
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method : " + method.getName() + " start ...");
                        Object o = method.invoke(tankD, args);
                        System.out.println("method : " + method.getName() + " end !");
                        return o;
                    }
                });

        m.move();
    }
}
