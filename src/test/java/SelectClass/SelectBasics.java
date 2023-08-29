package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void selectMethods(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select box = new Select(dropBox);
        String actualBox = box.getFirstSelectedOption().getText();
        String expectedBox = "Please select an option";

        Assert.assertEquals(actualBox, expectedBox);
        box.selectByVisibleText("Option 1");
        box.selectByValue("2");
        List<WebElement> allOptions = box.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");

        for (int i=0; i< allOptions.size(); i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(), expectedOptions.get(i));
        }




    }

}
