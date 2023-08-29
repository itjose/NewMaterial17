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

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceptAndGetText(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlertBTN = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlertBTN.click();

        Alert alert = driver.switchTo().alert(); //pop up handles
        String actualMessage = alert.getText();
        alert.accept();
        String expectedMessage ="I am a JS Alert";

        Assert.assertEquals(actualMessage, expectedMessage);

        WebElement successMessage = driver.findElement(By.id("result"));
        String actualSuccess = BrowserUtils.getText(successMessage);
        String expectedSuccess = "You successfully clicked an alert";

        Assert.assertEquals(actualSuccess, expectedSuccess);

    }

    @Test
    public void Dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();

        Alert alerts = driver.switchTo().alert();
        alerts.dismiss();
        WebElement successMessage = driver.findElement(By.id("result"));
        String actualMessage = BrowserUtils.getText(successMessage);
        String expectedMessage = "You clicked: Cancel";

        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void SendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));

        jsPrompt.click();
        Alert alerts = driver.switchTo().alert();
        alerts.sendKeys("I love java");
        alerts.accept();

        WebElement successMessage = driver.findElement(By.id("result"));
        String actualMessage = BrowserUtils.getText(successMessage);
        String expectedMessage = "You entered: I love java";

        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
