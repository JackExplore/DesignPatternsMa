package spring;

public class TimeProxy {

    public void before(){
        System.out.println("Method Start ... " + System.currentTimeMillis());
    }

    public void after(){
        System.out.println("Method End ... " + System.currentTimeMillis());
    }
}
