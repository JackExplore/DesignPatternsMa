package springAuto;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {

    @Before("execution(void springAuto.Tank.move())")
    public void before(){
        System.out.println("Method Start ... " + System.currentTimeMillis());
    }

    @After("execution(void springAuto.Tank.move())")
    public void after(){
        System.out.println("Method End ... " + System.currentTimeMillis());
    }
}
