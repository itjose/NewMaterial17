package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveToElement {

    @Test
    public void MoveToElementMethod(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='figure']"));

        List<WebElement> allNames = driver.findElements(By.xpath("//h5"));

        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");

        for (int i=0; i< allImages.size(); i++){
            actions.moveToElement(allImages.get(i)).perform();

            Assert.assertEquals(BrowserUtils.getText(allNames.get(i)),expectedNames.get(i));

            System.out.println(BrowserUtils.getText(allNames.get(i)));

        }




    }
}
