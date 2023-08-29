package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement text = driver.findElement(By.tagName("body"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "LEFT";
        Assert.assertEquals(actualText, expectedText);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleText = driver.findElement(By.id("content"));
        String actualMiddle = BrowserUtils.getText(middleText);
        String expectedMiddle = "MIDDLE";
        Assert.assertEquals(actualMiddle, expectedMiddle);


        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightText = driver.findElement(By.tagName("body"));
        String actualRight = BrowserUtils.getText(rightText);
        String expectedRight = "RIGHT";
        Assert.assertEquals(actualRight, expectedRight);

       // driver.switchTo().parentFrame();
       // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent(); // wherever you are it will go to home page.
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.tagName("body"));
        String actualBottomText = BrowserUtils.getText(bottom);
        String expectedBottomText = "BOTTOM";

        Assert.assertEquals(actualBottomText, expectedBottomText);


    }

}
