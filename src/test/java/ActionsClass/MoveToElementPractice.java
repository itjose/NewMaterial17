package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class MoveToElementPractice {

    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(1000);
        List<WebElement> allBoxes = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
                                                        //parent->child xpath-------->
        Actions actions = new Actions(driver);

        HashMap<String, String> productsPrices = new HashMap();

        for (int i=0; i < allBoxes.size(); i++){
            actions.moveToElement(allBoxes.get(i)).perform();
            productsPrices.put(BrowserUtils.getText(allProducts.get(i)),
                    (BrowserUtils.getText(allPrices.get(i))));

        }

        System.out.println(productsPrices);
    }
}
