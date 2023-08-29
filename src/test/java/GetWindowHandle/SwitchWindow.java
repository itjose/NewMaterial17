package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchWindow() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickBTN = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));

        clickBTN.click();
        Thread.sleep(1000);
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows){
            if(!window.equals(originalWindow)){
                driver.switchTo().window(window);
            }

        }



        WebElement text = driver.findElement(By.xpath("//h3"));

        System.out.println(BrowserUtils.getText(text));



    }

    @Test
    public void switchWindowPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTabBTN = driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollIntoView(driver, newTabBTN);
        newTabBTN.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String page : allPages){
            if (!page.equals(mainPageId)){
                driver.switchTo().window(page);
                break;
            }
        }
        Thread.sleep(500);

        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeaderPage2 = BrowserUtils.getText(header);
        String expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeaderPage2, expectedHeader);

        WebElement clickMeBTN = driver.findElement(By.xpath("//button[@id='alertBox']"));
        clickMeBTN.click();
        Thread.sleep(2000);
        driver.quit();





    }




}
