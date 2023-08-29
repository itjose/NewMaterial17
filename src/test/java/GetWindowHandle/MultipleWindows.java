package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class MultipleWindows {

    @Test
    public void multipleWindows(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");

        /*
        Set<String> allPages = driver.getWindowHandles();
        for (String pageID: allPages){
            driver.switchTo().window(pageID);
            if (driver.getTitle().contains("About")){
                break;
            }
        }

         */

        BrowserUtils.switchWindow(driver, "About");
        System.out.println(driver.getTitle());

    }

    @Test
    public void multipleWindowsPractice() throws InterruptedException {

        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        7-quit all the pages.
        8-Proud of yourself
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement multipleTabsBTN = driver.findElement(By.id("newTabsBtn"));
        BrowserUtils.scrollIntoView(driver, multipleTabsBTN);
        multipleTabsBTN.click();
        BrowserUtils.switchWindow(driver,
                "Basic Controls - H Y R Tutorials");
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Jose");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Hernandez");
        WebElement genderRadioBTN = driver.findElement(By.id("malerb"));
        if(genderRadioBTN.isDisplayed() && !genderRadioBTN.isSelected()){
            genderRadioBTN.click();
        }

        WebElement language = driver.findElement(By.id("spanishchbx"));
        BrowserUtils.clickWithJS(driver,language);

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("jose@yahoo.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("joe&mama");
        WebElement scrollToBottomOfPage = driver.findElement(By.xpath("//div[@class='ty_footer_copyright']"));
        BrowserUtils.scrollIntoView(driver, scrollToBottomOfPage);
        WebElement registerBTN = driver.findElement(By.id("registerbtn"));
        BrowserUtils.scrollIntoView(driver, registerBTN);
        Thread.sleep(2000);
        registerBTN.click();
        WebElement successfulMessage = driver.findElement(By.xpath("//label[contains(text(), 'Registration is Successful')]"));
        String actualMessage = BrowserUtils.getText(successfulMessage);
        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(actualMessage, expectedMessage);
        BrowserUtils.switchWindow(driver,
                "Window Handles Practice - H Y R Tutorials");
        Thread.sleep(1000);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle =
                "Window Handles Practice - H Y R Tutorials";

        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(500);

        BrowserUtils.switchWindow(driver,
                "AlertsDemo - H Y R Tutorials");
        Thread.sleep(1000);
        String actualAlertsTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedAlertsTitle =
                "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualAlertsTitle, expectedAlertsTitle);

        WebElement clickButton = driver.findElement(By.id("promptBox"));
        BrowserUtils.scrollIntoView(driver, clickButton);
        clickButton.click();
        Thread.sleep(1000);
        driver.quit();






    }


}
