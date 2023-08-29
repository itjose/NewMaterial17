package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {

    //driver.get
    //driver.manage.window.maximize()
    //driver.navigate.to()
    //driver.navigate.refresh()
    //driver.navigate.forward() & back()
    //driver.navigate.getPageSource()

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource()); it is barely used.
        driver.quit();



    }
}
