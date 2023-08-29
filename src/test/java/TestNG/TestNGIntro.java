package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGIntro {

    @Test (priority = 1)
    public void test1(){
        System.out.println("test1");
    }

    @Test (priority = 3, invocationCount = 5)
    public void test3(){
        System.out.println("test3");
    }
    @Test (priority = 2)
    public void z (){
        System.out.println("test2");

    }


}
