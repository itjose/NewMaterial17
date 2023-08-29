package iFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FramePractice {

    @Test

    public void frame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");

        WebElement p = driver.findElement(By.cssSelector("#tinymce"));
        p.clear();
        p.sendKeys("I love java. ❤️");

        driver.switchTo().parentFrame();
        WebElement selenium = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(BrowserUtils.getText(selenium));


    }

    @Test
    public void practiceTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilionBTN = driver.findElement(By.linkText("Pavilion"));
        pavilionBTN.click();
        Thread.sleep(500);
        BrowserUtils.switchWindow(driver, "Home - qavalidation");
        WebElement hoverSelenium = driver.findElement(By.xpath("//span[@class='menu-item-text']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverSelenium).perform();
        WebElement dropdown = driver.findElement(By.xpath(
                "//a[@data-level='2']//span[contains(text(), 'Selenium-Python')]"));
        dropdown.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        System.out.println(allLinks.size());
    }


    @Test
    public void task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        WebElement category1BTN = driver.findElement(By.xpath("//a[.='Category1']"));
        category1BTN.click();
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        BrowserUtils.switchWindow(driver, "SeleniumTesting Archives");

         WebElement header = driver.findElement(By.tagName("h1"));
         String actualHeader = BrowserUtils.getText(header);
         String expectedHeader = "Category Archives: SeleniumTesting";

        Assert.assertEquals(actualHeader, expectedHeader);
        List<WebElement> allBoxes = driver.findElements(By.xpath("//div//h3"));
        for (WebElement box : allBoxes){
            System.out.println(BrowserUtils.getText(box));
        }

        Thread.sleep(500);

        BrowserUtils.switchWindow(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement textInFrame = driver.findElement(By.id("frametext"));
        System.out.println(BrowserUtils.getText(textInFrame));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        BrowserUtils.switchWindow(driver, "SoftwareTesting Archives");
        WebElement header2 = driver.findElement(By.tagName("h1"));
        String actualText2 = BrowserUtils.getText(header2);
        String expectedText2 = "Category Archives: SoftwareTesting";

        Assert.assertEquals(actualText2, expectedText2);


    }



}
