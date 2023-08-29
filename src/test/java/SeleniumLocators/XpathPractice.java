package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // MUST use different email every time.

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Jose");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Hernandez");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("jose.hernand4@gmail.com");

        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("847-505-7856");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("talk235g");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("talk235g");

        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(privacyPolicy.isDisplayed() && !privacyPolicy.isSelected()){
            privacyPolicy.click();
        }

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();


        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'Created!')]"));
        String actualText = header.getText();
        String expectedText = "Your Account Has Been Created!";

        WebElement button2 = driver.findElement(By.xpath("//a[ @class='btn btn-primary']"));
        button2.click();

        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";

        System.out.println(actualUrl.equals(expectedUrl) ? "passed test" : "failed test");

        driver.close();









    }
}
