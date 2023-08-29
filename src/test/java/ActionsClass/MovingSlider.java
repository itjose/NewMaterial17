package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovingSlider {

    @Test

    public void validateSliderFunctionality(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.tagName("input"));
        WebElement value = driver.findElement(By.xpath("//span[@id='range']"));
        String expectedValue ="4";
        while(!BrowserUtils.getText(value).equals(expectedValue)){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }


        Assert.assertEquals(BrowserUtils.getText(value), expectedValue);




    }
}
