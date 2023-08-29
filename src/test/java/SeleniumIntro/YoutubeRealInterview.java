package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterview {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");
        searchBar.sendKeys(Keys.ENTER);



        List<WebElement> Titles = driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement title : Titles){

            if (title.getAttribute("title").equals("Justin Bieber - Baby ft. Ludacris")){
                Thread.sleep(3000);
                title.sendKeys(Keys.ARROW_DOWN);
                title.click();
            }

        }

        //Thread.sleep(3000);
        //WebElement closeTab = driver.findElement(By.xpath("//div[@class='yt-spec-touch-feedback-shape__fill']"));
        //closeTab.click();

        WebElement video = driver.findElement(By.xpath("//div[@id='movie_player']"));
        Thread.sleep(16000);
        //video.sendKeys(Keys.ARROW_DOWN);
        String time = video.getAttribute("ytp-time-current");
        Thread.sleep(2000);
        System.out.println(time);
        driver.close();






    }
}
