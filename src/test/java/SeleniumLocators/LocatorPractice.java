package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
                /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement firstName = driver.findElement(By.name("firstname"));
                    firstName.sendKeys("Jose");
        WebElement lastName = driver.findElement(By.name("lastname"));
                    lastName.sendKeys("Hernandez");
        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement experienceYears = driver.findElement(By.id("exp-3"));
        experienceYears.click();


        js.executeScript("window.scrollBy(0,350)", "");


        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("12-3-2023");

        WebElement manualTester = driver.findElement(By.id("profession-0"));
        manualTester.click();

        WebElement professionAutomation = driver.findElement(By.id("profession-1"));
        professionAutomation.click();


        WebElement tools = driver.findElement(By.id("tool-2"));
        tools.click();


        WebElement continents = driver.findElement(By.id("continents"));
        continents.sendKeys("Antartica");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String pageUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";

        System.out.println(pageUrl.equals(expectedUrl) ? "Passed Url" : "Failed Url");

                driver.close();








    }
}
