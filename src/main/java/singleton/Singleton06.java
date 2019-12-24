package singleton;

/**
 * OK
 * 添加双重检查，保证了线程安全
 */
public class Singleton06 {

    private static volatile Singleton06 INSTANCE;   // 要加上 volatile : JIT 避免语句重排问题

    private Singleton06() {
    }

    public static Singleton06 getInstance() {
        // 双重检查
        if (INSTANCE == null) {
            // 试图通过同步代码块的方式提高效率
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
                    System.out.println(Singleton06.getInstance().hashCode())
            ).start();
        }
    }
}
