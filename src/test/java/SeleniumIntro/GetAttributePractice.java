package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        WebElement collapseButton = driver.findElement(By.xpath("//button[contains(text(), 'collapse')]"));
        collapseButton.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

        String uncheckBoxes = "false";

        for (WebElement checkbox : checkBoxes) {
            if (checkbox.getAttribute("aria-checked").equals(uncheckBoxes)){
                checkbox.click();

            }

        }

    }
}