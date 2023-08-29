package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class JSPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement yesBTN = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Actions actions = new Actions(driver);
        actions.click(yesBTN).perform();
        WebElement selectionText = driver.findElement(By.xpath("//p[@class='mt-3']//span[@class='text-success']"));
        String actualYesText = BrowserUtils.getText(selectionText);
        String expectedYesText = "Yes";
        Assert.assertEquals(actualYesText, expectedYesText);
        WebElement impressiveBTN = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", impressiveBTN);
        selectionText = driver.findElement(By.xpath("//p[@class='mt-3']//span[@class='text-success']"));

        actualYesText = BrowserUtils.getText(selectionText);
        String expectedImpressive ="Impressive";

        Assert.assertEquals(actualYesText, expectedImpressive);

        WebElement noRadio = driver.findElement(By.xpath("//input[@id='noRadio']"));
        Assert.assertFalse(noRadio.isSelected());


    }

    @Test
    public void practiceALlJS() throws InterruptedException {

        /*
        scroll to copyright and validate
        Scroll up to "launch a new career"
        click apply button
        validate title
        validate text in three boxes
        close.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyright = driver.findElement(By.cssSelector("#el_1666192783854_462"));
        BrowserUtils.scrollIntoView(driver, copyright);
        String actualCopyrightText = BrowserUtils.getText(copyright);
        String expectedCopyrightText = "Copyright © 2023";
        Assert.assertEquals(actualCopyrightText, expectedCopyrightText);

        WebElement homePageHeader = driver.findElement(By.cssSelector("#el_1668758467708_538"));
        BrowserUtils.scrollIntoView(driver, homePageHeader);
        Thread.sleep(1000);
        WebElement applyBTN = driver.findElement(By.cssSelector("#el_1668758467710_541"));
        applyBTN.click();
        //Actions actions = new Actions(driver);
        //actions.click(applyBTN);
        Thread.sleep(500);

        String mainPage = driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for (String pages : allPages){
            if (!pages.equals(mainPage)){
                driver.switchTo().window(pages);
                break;
            }
        }
        Thread.sleep(500);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle = "Apply Now";

        Assert.assertEquals(actualTitle, expectedTitle);






    }

}
