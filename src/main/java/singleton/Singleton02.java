package singleton;

/**
 * 和 01 是一个意思
 */
public class Singleton02 {

    private static final Singleton02 singleton02;

    static {
        singleton02 = new Singleton02();
    }

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return singleton02;
    }

    public static void main(String[] args) {
        Singleton02 A = Singleton02.getInstance();
        Singleton02 B = Singleton02.getInstance();
        System.out.println(A == B);
    }
}
