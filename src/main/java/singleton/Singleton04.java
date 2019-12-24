package singleton;

import java.util.concurrent.TimeUnit;

/**
 * 线程安全，但是效率降低了
 */
public class Singleton04 {

    private static Singleton04 INSTANCE;

    private Singleton04() {
    }

    public static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
                    System.out.println(Singleton04.getInstance().hashCode())
            ).start();
        }
    }
}
