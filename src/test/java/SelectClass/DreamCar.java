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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

            /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */


    @Test
    public  void searchFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");
        Thread.sleep(2000);
        WebElement carUsedNew = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(carUsedNew, "New", "text");
        WebElement carMake = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(carMake, "lexus", "value");
        WebElement carModel = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(carModel, "RX 350", "text");
        WebElement priceList = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select price = new Select(priceList);
        String actualPrice = price.getFirstSelectedOption().getText().trim();
        String expectedPrice = "No max price";
        Assert.assertEquals(actualPrice, expectedPrice);

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40", "value");

        WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        zip.sendKeys("60056");
        WebElement searchBTN = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchBTN.click();
        Thread.sleep(1000);
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'for sale')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "New Lexus RX 350 for sale";
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy, "list_price", "value");
        Thread.sleep(1500);

        List<WebElement> allCars = driver.findElements(By.xpath("//div[@class='vehicle-card']"));
        int count =0;

        for( int i=0; i< allCars.size(); i++){
            Assert.assertTrue(allCars.get(i).getText().contains("Lexus RX 350")); //asserts true
            count++; //counts
            System.out.println(allCars.get(i).getText().contains("Lexus RX 350")); // prints true
        }


        System.out.println(count);
    }

    @Test

    public void dreamCarFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        Thread.sleep(3000);
        WebElement carUsedNew = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(carUsedNew, "New", "text");
        WebElement carMake = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(carMake, "honda", "value");
        WebElement carModel = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(carModel, "CR-V", "text");
        WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        zip.sendKeys("60639");
        WebElement searchBTN = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchBTN.click();
        Thread.sleep(1000);
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy, "Lowest price", "text");
        Thread.sleep(3000);
        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='primary-price']"));

        List<Double> actualPriceAsc = new ArrayList<>();
        List<Double> expectedPrice = new ArrayList<>();

        //for (WebElement price:priceList) {
          //  actualPriceAsc.add(price.getText());
        //}

        for(int i=0; i< priceList.size(); i++){
            //Thread.sleep(500);
            actualPriceAsc.add(Double.parseDouble(priceList.get(i).getText().replace("$","").replace(",","").trim()));
            expectedPrice.add( Double.parseDouble(priceList.get(i).getText().replace("$","").replace(",","").trim()));
            //expectedPrice.add(Double.parseDouble(priceList.get(i).getText().replace("$","").trim()));
        }


        Collections.sort(expectedPrice);


        Assert.assertEquals(actualPriceAsc, expectedPrice);
        System.out.println(actualPriceAsc);
        System.out.println(expectedPrice);

       Thread.sleep(500);
       BrowserUtils.selectBy(sortBy,"list_price_desc","value");
       Thread.sleep(2000);

        List<WebElement> priceListDesc = driver.findElements(By.xpath("//span[@class='primary-price']"));

        List<Integer> actualDesc = new ArrayList<>();
        List<Integer> expectedDesc = new ArrayList<>();

        for(int i=0; i<priceListDesc.size(); i++){
            actualDesc.add(Integer.parseInt(priceListDesc.get(i).getText().replace("$","").replace(",","").trim()));
            expectedDesc.add(Integer.parseInt(priceListDesc.get(i).getText().replace("$", "").replace(",", "").trim()));
        }
        Collections.sort(expectedDesc);
        Collections.reverse(expectedDesc);


        Assert.assertEquals(actualDesc, expectedDesc);
        System.out.println(actualDesc);
        System.out.println(expectedDesc);

        driver.close();

    }



}
