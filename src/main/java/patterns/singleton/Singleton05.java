package patterns.singleton;

/**
 * 试图通过同步代码块的方式提高效率
 * 但是，也不能保证线程安全
 */
public class Singleton05 {

    private static Singleton05 INSTANCE;

    private Singleton05() {
    }

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            // 试图通过同步代码块的方式提高效率
            synchronized (Singleton05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->
                    System.out.println(Singleton05.getInstance().hashCode())
            ).start();
        }
    }
}
