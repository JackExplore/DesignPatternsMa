package patterns.singleton;

/**
 * OK - 实用
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 实用简单，推荐实用！
 * 不足：不管用到与否，类加载时就完成实例化
 * (话说你不用的，你装载它干啥)
 */
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 A = Singleton01.getInstance();
        Singleton01 B = Singleton01.getInstance();
        System.out.println(A == B);
    }
}
