package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExample {

    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            4. Close browser.


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.godaddy.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Godaddy Pass Title");
        }else{
            System.out.println("failed");
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";

        /*
        if (actualUrl.equals(expectedUrl)){
            System.out.println("url pass test");
        }else{
            System.out.println("failed url test");
        }

         */

        System.out.println(actualUrl.equals(expectedUrl) ? "Passed URL" : "Failed Url"); // ternary operator

        driver.close();

    }
}
