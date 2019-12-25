package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;


/**
 * 使用 JDK 的动态代理
 * 内部类 - 存文件
 */
public class TankF implements Movable {
    @Override
    public void move() {
        System.out.println("TankF moving calclacla ......");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TankF tankF = new TankF();

//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // reflection - 通过字节码分析类的属性和方法，动态代理
        Movable m = (Movable) Proxy.newProxyInstance(TankF.class.getClassLoader(), // ClassLoader() 类的加载器
                new Class[]{Movable.class},     // 实现的接口数组
                new TimeProxyT(tankF));

        m.move();   //
    }
}

class TimeProxyT implements InvocationHandler {

    TankF tankF;

    public TimeProxyT(TankF tankF){
        this.tankF = tankF;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("method : " + method.getName() + " start ...");
        Object o = method.invoke(tankF, args);
        System.out.println("method : " + method.getName() + " end !");
        return o;
    }
}
