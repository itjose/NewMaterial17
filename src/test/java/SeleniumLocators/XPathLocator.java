package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathLocator {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.partialLinkText("Testing"));
        abTesting.click();

        WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
                header.getText();
                WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Elemental Selenium')]"));
                link.click();



    }
}
