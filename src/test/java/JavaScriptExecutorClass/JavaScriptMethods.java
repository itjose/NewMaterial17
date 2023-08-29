package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void getTitle(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        //System.out.println(driver.getTitle() + " driver method");

        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // System.out.println(js.executeScript("return document.title") + " with JS method");
        System.out.println(BrowserUtils.getTitleWithJS(driver));


    }

    @Test
    public void ClicksJS() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        WebElement aboutUsBTN = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUsBTN.click();
        driver.navigate().back();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.click(aboutUsBTN).perform();
        driver.navigate().back();
        Thread.sleep(5000);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click()",aboutUsBTN);

        BrowserUtils.clickWithJS(driver, aboutUsBTN);


    }

    @Test
    public void ScrollIntoView() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement address = driver.findElement(By.xpath("//p[contains(text(), 2200)]"));
        //js.executeScript("arguments[0].scrollIntoView(true)", address);
        //System.out.println(BrowserUtils.getText(address));
        BrowserUtils.scrollIntoView(driver,address);
        Thread.sleep(2000);
        WebElement aboutUsBTN = driver.findElement(By.xpath("//button[.='Contact Us']"));
        //js.executeScript("arguments[0].scrollIntoView(true)", aboutUsBTN);
        BrowserUtils.scrollIntoView(driver, aboutUsBTN);
        aboutUsBTN.click();


    }




}
