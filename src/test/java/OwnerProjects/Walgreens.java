package OwnerProjects;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Walgreens {

    @Test
    public void validateTitles() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.walgreens.com/");
        WebElement contactLensBTN =
                driver.findElement(By.xpath(
                        "//div[@class='product']//span[contains(text(), 'Contact Lenses')]"));
        contactLensBTN.click();
        List<WebElement> highLights = driver.findElements(By.xpath("//div[@class='product__title']"));
        List<String> expectedProducts = new ArrayList(Arrays.asList(
                "Rebate Center", "Contact Lens Solution", "Contact Lens Cases"));
        for (int i = 0; i < highLights.size(); i++) {
            Assert.assertEquals(highLights.get(i).getText(), expectedProducts.get(i));
            // System.out.println(BrowserUtils.getText(highLights.get(i)));
        }

        List<WebElement> topContactLensList = driver.findElements(By.xpath("//div[@class='list__title']"));
        List<String> expectedList = new ArrayList<>(Arrays.asList(
                "Acuvue", "Air Optix", "Focus/Dailies", "CooperVision", "Bausch & Lomb", "Alcon"));

        for (int i = 0; i < topContactLensList.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(topContactLensList.get(i)), expectedList.get(i));
            System.out.println(BrowserUtils.getText(topContactLensList.get(i)));
        }

        List<WebElement> allLinks = driver.findElements(By.xpath(
                "//div[@class='card__topic']//ul[@class='links__listed']//a"));

        Set<String> allInSet = new TreeSet<>();
        for (int i = 0; i < allLinks.size(); i++) {
            Assert.assertTrue(allLinks.get(i).isDisplayed() && allLinks.get(i).isEnabled());
            System.out.println(allLinks.get(i).getText());
            allInSet.add(BrowserUtils.getText(allLinks.get(i)));

        }


        System.out.println(allInSet);

    }

    @Test

    public void beauty() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.walgreens.com/");
        WebElement beautyBTN = driver.findElement(By.xpath(
                "//div[@class='product']//span[contains(text(), 'Beauty')]"));
        beautyBTN.click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='text-center']"));
        List<String> expectedResults = new ArrayList<>(Arrays.asList(
                "Makeup", "Skin Care", "Hair Care", "Fragrance", "Sun Care", "Nails", "Bath & Body", "Influencer Approved"));

        Set<String> itemsList = new LinkedHashSet<>();
        for (int i = 0; i < allProducts.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allProducts.get(i)), expectedResults.get(i));
            itemsList.add(BrowserUtils.getText(allProducts.get(i)));
        }

        System.out.println(itemsList);
    }

}
