package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/anneconklelap/Downloads/Techtorialhtml.html");

        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText();
        String expectedVersion = "Use Java Version";

        System.out.println(actualVersion.equals(expectedVersion) ? "passed " : "failed");

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = header.getText();
        String expectedHeader = "Java";

        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "failed");

        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();

        WebElement selenium = driver.findElement(By.tagName("h1"));
        String actualSelenium = selenium.getText();
        String expectedSelenium = "Selenium automates browsers. That's it!";
        System.out.println(actualSelenium.equals(expectedSelenium) ? "Pass selenium" : "failed Selenium");

        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();

        WebElement cucumber = driver.findElement(By.tagName("h1"));
        String actualCucumberHeader = cucumber.getText();
        String expectedHeaderCucumber = "Tools & techniques that elevate teams to greatness";

        System.out.println(actualCucumberHeader.equals(expectedHeaderCucumber)? "cucumber pass" : "cucumber failed");

        driver.navigate().back();

        WebElement testngLink = driver.findElement(By.linkText("TestNG"));
        testngLink.click();
        WebElement testng = driver.findElement(By.linkText("Click for more details."));
        String actualTestNG = testng.getText();
        System.out.println(actualTestNG);
        String expectedTestng = "Click for more details.";
        System.out.println(actualTestNG.equals(expectedTestng) ? "pass" : "failed testing");

        driver.navigate().back();

        // PARTIAL LINK TEXT

        WebElement res_api = driver.findElement(By.partialLinkText("Rest"));
        res_api.click();
        System.out.println(driver.getTitle());




    }
}
