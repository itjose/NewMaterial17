package AlertsInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class Practice {

    @Test
    public void practice(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement buttonOne = driver.findElement(By.id("alertBox"));
        buttonOne.click();
        Alert alerts = driver.switchTo().alert();
        String actualDisplayMessage = alerts.getText();
        String expectedMessage = "I am an alert box!";
        Assert.assertEquals(actualDisplayMessage, expectedMessage);
        alerts.accept();

        WebElement result = driver.findElement(By.id("output"));
        String actualOutput = BrowserUtils.getText(result);
        String expectedOutput = "You selected alert popup";
        Assert.assertEquals(actualOutput, expectedOutput);


        WebElement secondButton = driver.findElement(By.id("confirmBox"));
        secondButton.click();
        String actualMessage = alerts.getText();
        String expected2ndMessage = "Press a button!";
        Assert.assertEquals(actualMessage, expected2ndMessage);
        alerts.dismiss();
        //WebElement popUpOutput2 = driver.findElement(By.id("output"));
        String actualOutput2 = BrowserUtils.getText(result);
        String expectedOutput2 = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualOutput2, expectedOutput2);

        WebElement buttonThree = driver.findElement(By.id("promptBox"));
        buttonThree.click();
        String actualMessageThree = alerts.getText();
        String expectedThreeMessage = "Please enter your name:";


        Assert.assertEquals(actualMessageThree, expectedThreeMessage);
        alerts.sendKeys("jose");
        alerts.accept();
        //WebElement popUpOutput3 = driver.findElement(By.id("output"));
        String actualOutput3 = BrowserUtils.getText(result);
        String expectedOutput3 = "You entered text jose in prompt popup";
        Assert.assertEquals(actualOutput3, expectedOutput3);






    }
}
