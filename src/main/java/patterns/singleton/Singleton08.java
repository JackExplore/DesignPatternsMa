package patterns.singleton;

/**
 * 不仅可以解决线程同步，而且可以防止反序列化，据说是完美中的完美
 * <p>
 * 因为枚举类型没有构造方法，所以就算拿到它的 Class 对象，也可以防止构造它的对象
 */
public enum Singleton08 {

    INSTANCE;

    public void m() {
        System.out.println(this.hashCode());
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton08.INSTANCE.m();
            }
            ).start();
        }

    }
}
