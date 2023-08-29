package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectMidLevel {
 /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available"


 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */

    @Test
    public void travelConfirmation() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement typeBTN = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeBTN.click();
        WebElement numberPassengerDropdown = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passCount = new Select(numberPassengerDropdown);
        passCount.selectByVisibleText("4");
        WebElement departDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart = new Select(departDropdown);
        String actualDepart = depart.getFirstSelectedOption().getText();
        String expectedDepart = "Acapulco";

        Assert.assertEquals(actualDepart, expectedDepart);

        depart.selectByValue("Paris");
        WebElement departMonthDrop = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthDepart = new Select(departMonthDrop);
        monthDepart.selectByValue("8");

        WebElement departDayDrop = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dayDepart = new Select(departDayDrop);
        dayDepart.selectByVisibleText("15");

        WebElement arriveDropDown = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(arriveDropDown);
        arrivalCity.selectByVisibleText("San Francisco");

        WebElement arrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select arrival = new Select(arrivalMonth);
        arrival.selectByVisibleText("December");

        WebElement arrivaldayDrp = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dayArrival = new Select(arrivaldayDrp);
        dayArrival.selectByValue("15");

        WebElement firstClassBTN = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassBTN.click();

        WebElement airlineList = driver.findElement(By.xpath("//select[@name='airline']"));

        Select allAirlines = new Select(airlineList);

        List<WebElement> allLine = allAirlines.getOptions();

        List<String> expectedAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allLine.size(); i++) {
            Assert.assertEquals(allLine.get(i).getText().trim(), expectedAirlines.get(i));
        }

        allAirlines.selectByVisibleText("Unified Airlines");
        WebElement continueBTN = driver.findElement(By.xpath("//input[@name='findFlights']"));

        continueBTN.click();
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = header.getText().trim();

        String expectedHeader = "After flight finder - No Seats Available";

        Assert.assertEquals(actualHeader, expectedHeader);


    }

    @Test

    public void shortCutAutomation() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement typeBTN = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeBTN.click();
        WebElement numberPassengerDropdown = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(numberPassengerDropdown, "4", "text");
        //Select passCount = new Select(numberPassengerDropdown);
        //passCount.selectByVisibleText("4");
        WebElement departDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart = new Select(departDropdown);
        String actualDepart = depart.getFirstSelectedOption().getText();
        String expectedDepart = "Acapulco";

        Assert.assertEquals(actualDepart, expectedDepart);

        depart.selectByValue("Paris");
        WebElement departMonthDrop = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(departMonthDrop, "8", "value");
        //Select monthDepart = new Select(departMonthDrop);
        //monthDepart.selectByValue("8");

        WebElement departDayDrop = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(departDayDrop, "15", "text");
        //Select dayDepart = new Select(departDayDrop);
        //dayDepart.selectByVisibleText("15");

        WebElement arriveDropDown = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(arriveDropDown);
        arrivalCity.selectByVisibleText("San Francisco");

        WebElement arrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select arrival = new Select(arrivalMonth);
        arrival.selectByVisibleText("December");

        WebElement arrivaldayDrp = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dayArrival = new Select(arrivaldayDrp);
        dayArrival.selectByValue("15");

        WebElement firstClassBTN = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassBTN.click();

        WebElement airlineList = driver.findElement(By.xpath("//select[@name='airline']"));

        Select allAirlines = new Select(airlineList);

        List<WebElement> allLine = allAirlines.getOptions();

        List<String> expectedAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < allLine.size(); i++) {
            Assert.assertEquals(allLine.get(i).getText().trim(), expectedAirlines.get(i));
        }

        allAirlines.selectByVisibleText("Unified Airlines");
        WebElement continueBTN = driver.findElement(By.xpath("//input[@name='findFlights']"));

        continueBTN.click();
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = header.getText().trim();

        String expectedHeader = "After flight finder - No Seats Available";

        Assert.assertEquals(actualHeader, expectedHeader);

    }

}
