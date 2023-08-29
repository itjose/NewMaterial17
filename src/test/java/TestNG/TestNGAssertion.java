package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiply(int num1, int num2){
        return  num1*num2;
    }

    @Test
    public void validateMultiplication(){

        int actualResult = multiply(3,4);
        int expectedResult =12;
        // no more if statement
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public  void validateZeroLogic(){
        int actualResult = multiply(0,999);
        int expectedResult = 0;

        Assert.assertTrue(actualResult==expectedResult);
    }

}
