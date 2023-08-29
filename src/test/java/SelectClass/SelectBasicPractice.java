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
import java.util.List;

public class SelectBasicPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/anneconklelap/Downloads/Techtorialhtml.html");

        WebElement dropBox = driver.findElement(By.xpath("//select[@name='country']"));

        Select checkBox = new Select(dropBox);
        String actualText = checkBox.getFirstSelectedOption().getText().trim();
        String expectedText = "UNITED STATES";

        Assert.assertEquals(actualText, expectedText);

        List<WebElement> allCountries =  checkBox.getOptions();

        int count=0;
        List<String> printList = new ArrayList<>();

        for (WebElement country:allCountries) {

            printList.add(country.getText());
            count++;

        }

        System.out.println(printList);
        System.out.println(count);

        checkBox.selectByValue("190");
        Thread.sleep(1000);
        checkBox.selectByVisibleText("MEXICO");
        Thread.sleep(1000);
        checkBox.selectByIndex(145);

    }


}