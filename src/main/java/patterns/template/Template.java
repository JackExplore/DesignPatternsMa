package patterns.template;

public class Template {

    public static void main(String[] args) {
        T t = new T();
        t.m();
    }
}


abstract class F{
    public void m(){
        p1();
        p2();
    }
    abstract void p1();
    abstract void p2();
}

class T extends F{

    @Override
    void p1() {
        System.out.println("p1 ...");
    }

    @Override
    void p2() {
        System.out.println("p2 ...");
    }
}