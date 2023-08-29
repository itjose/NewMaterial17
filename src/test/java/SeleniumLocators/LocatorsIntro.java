package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    // Locators is a way to find the elements and manipulate them.

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("file:///Users/anneconklelap/Downloads/Techtorialhtml.html");

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText();
        String expectedText ="Techtorial Academy";
        System.out.println(actualHeader.equals(expectedText) ? "passed" : "failed");
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //name locators

        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement email = driver.findElement(By.name("userName"));
        WebElement address = driver.findElement(By.name("address1"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement zipcode = driver.findElement(By.name("postalCode"));



        firstName.sendKeys("Jose");
        lastName.sendKeys("Hernandez");
        phone.sendKeys("3127887079");
        email.sendKeys("jose.hernandez@gmail.com");
        address.sendKeys("123 main street");
        city.sendKeys("chicago");
        state.sendKeys("Illinois");
        zipcode.sendKeys("60641");

    // Class name locator -> " //select [@class="select"] "

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        WebElement testNgBox = driver.findElement(By.id("cond3"));
        WebElement cucumberBox = driver.findElement(By.id("cond4"));

        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "Java is Selected" : " Java Not selected");

        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }
        System.out.println(seleniumBox.isSelected() ? "Selenium is selected" : " selenium not selected");

        if (testNgBox.isDisplayed() && !testNgBox.isSelected()){
            testNgBox.click();
        }

        System.out.println(testNgBox.isSelected() ? "testNg is selected" : "selenium is not selected");

        if (cucumberBox.isDisplayed() && !cucumberBox.isSelected()){
            cucumberBox.click();
        }

        System.out.println(cucumberBox.isSelected() ? "cucumber is selected " : "cucumber is not selected");


    }
}
