package factory;

public class Main {

    public static void main(String[] args) {

        /**
         * V.A
         */
//        Car c = new Car();
//        c.go();

//        Plane p = new Plane();
//        p.go();

        /**
         * V.B
         */
//        Movable m = new Plane();
//        m.go();

        /**
         * V.C
         */
        Car c = CarFactory.getInstance().create();
        c.go();
    }
}
