package AlertsInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAndHTML {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));

        button1.click();
        Alert alerts = driver.switchTo().alert();
        String actualMessage = alerts.getText();
        String expectedMessage = "Oops, something went wrong!";

        Assert.assertEquals(actualMessage, expectedMessage);
        alerts.accept();

        WebElement secondBTN = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        secondBTN.click();
        WebElement popUpBTN = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        Thread.sleep(1000);
        popUpBTN.click();
        driver.close();






    }
}
