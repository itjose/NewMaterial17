package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

    public static void main(String[] args) {

        //setup for automation
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions(); //create object for headless
        options.addArguments("--headless=new");

        //create driver
        WebDriver driver = new ChromeDriver(options); //create object for driver and pass headless object


        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Passed");
        } else {
            System.out.println("Title Failed");
        }


        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url passed");
        }else{
            System.out.println("Url failed");
        }
        //homework
        // go to three different website and validate title and url

        driver.get("https://www.adidas.com/us");
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "adidas Official Website | adidas US";
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Adidas Pass title ");
        }else{
            System.out.println("adidas failed title.");
        }

        String actualUrlAdidas = driver.getCurrentUrl();
        String expectedUrlAdidas = "https://www.adidas.com/us";
        if (actualUrlAdidas.equals(expectedUrlAdidas)){
            System.out.println("Adidas url pass.");
        }else{
            System.out.println("adidas url failed");
        }

        driver.get("https://www.footlocker.com/");
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "#becausesneakers | Sneakers, Apparel & More | Foot Locker";
        if (actualTitle2.equals(actualTitle2)){
            System.out.println("footlocker title pass");
        }else{
            System.out.println("footlocker title failed.");
        }
        String actualUrlFootlocker = driver.getCurrentUrl();
        String expectedUrlFootlocker = "https://www.footlocker.com/";
        if(actualUrlFootlocker.equals(expectedUrlFootlocker)){
            System.out.println("footlocker url pass");
        }else{
            System.out.println("footlocker url failed");
        }

        driver.get("https://www.nike.com/");
        String actualTitleNike = driver.getTitle();
        String expectedTitleNike = "Nike. Just Do It. Nike.com";
        if (actualTitleNike.equals(expectedTitleNike)){
            System.out.println("Nike title pass.");
        }else{
            System.out.println("Nike tile failed");
        }

        String actualUrlNike = driver.getCurrentUrl();
        String expectedUrlNike = "https://www.nike.com/";

        if (actualUrlNike.equals(expectedUrlNike)){
            System.out.println("Nike Url pass.");
        }else{
            System.out.println("NIke Url failed");
        }
    }
}
