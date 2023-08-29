package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/anneconklelap/Downloads/Techtorialhtml.html");
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        int count =0;
        for (WebElement box: allBoxes) {
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
                box.click();
                count++;
                //System.out.println(box.isSelected() ? "Box Selected" : "box not selected");
                // You will get only three because one is already selected.
            }

            System.out.println(box.isSelected() ? "Box Selected" : "box not selected");
        }

        System.out.println(count);




    }
}
