package patterns.prototype.v1;

/**
 * 浅克隆
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc.street);
    }
}

class Person implements Cloneable{
    int age = 8;
    int score = 100;
    Location loc = new Location("bj", 22);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Location{
    String street;
    int num;
    public Location(String street, int x){
        this.street = street;
        this.num = num;
    }
}