package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com/");
        //WebElement searchBar = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        //searchBar.sendKeys("Watch", Keys.ENTER);

        WebElement searchBar2 = driver.findElement(By.cssSelector(".wt-input"));
        searchBar2.sendKeys("Watch", Keys.ENTER);

    }


}
