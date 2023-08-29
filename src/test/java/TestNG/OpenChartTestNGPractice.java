package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {


    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("d4546");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement alertMessage = driver.findElement(By.cssSelector("#alert"));
        Thread.sleep(1000);
        String actualMessage = alertMessage.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";

        Assert.assertEquals(actualMessage, expectedMessage);



    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement popUpButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        popUpButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        catalogButton.click();

        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));

        Assert.assertTrue(productButton.isDisplayed() && productButton.isEnabled());


    }

    @Test
    public void validBoxesInProducts() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement popUpButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        popUpButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        catalogButton.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productButton.click();

        List<WebElement> table = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //table[@class='table table-bordered table-hover']

        System.out.println(table.size());
        for(int i=1; i<table.size(); i++){

            Assert.assertTrue(table.get(i).isDisplayed() && table.get(i).isEnabled());

            Assert.assertFalse(table.get(i).isSelected());
            Thread.sleep(500);
            table.get(i).click();
            Thread.sleep(500);
            Assert.assertTrue(table.get(i).isSelected());
            Thread.sleep(500);
            table.get(i).sendKeys(Keys.ARROW_DOWN);



        }

    }

    @Test

    public void productNameDesc() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement popUpButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        popUpButton.click();
        WebElement catalogButton = driver.findElement(By.xpath("//i[@class='fas fa-tag']"));
        catalogButton.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productButton.click();
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));

        List<WebElement> products = table.findElements(By.xpath("//td[@class='text-start']"));



        Set<String> productList = new LinkedHashSet();
        for(int i=1; i < products.size(); i++){

            Thread.sleep(2000);
            productList.add(products.get(i).getText().substring(0, products.get(i).getText().length()-7));
            Thread.sleep(2000);

        }


        WebElement nextBTN = driver.findElement(By.xpath("//a[contains(text(), 2)]"));
        nextBTN.click();

        Thread.sleep(2000);
        table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));

        products = table.findElements(By.xpath("//td[@class='text-start']"));

        for (int j=1; j < products.size(); j++){

            productList.add(products.get(j).getText().substring(0, products.get(j).getText().length()-7));
            Thread.sleep(2000);

        }
        ArrayList arrayList = new ArrayList(productList);

        Collections.reverse(arrayList);

        //driver.navigate().back();

        WebElement page1 = driver.findElement(By.xpath("//a[contains(text(), 1)]"));
        page1.click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-350)","");
        Thread.sleep(3000);
        table = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));

        WebElement productNameBtn = driver.findElement(By.xpath("//a[contains(text(), 'Product Name')]"));
        productNameBtn.click();
        products = table.findElements(By.xpath("//td[@class='text-start']"));

        WebElement firstProductLine2 = driver.findElement(By.xpath("//td[contains(text(), 'Sony VAIO')]"));
        //Line one in descending, first element/product.
        String actualProduct = firstProductLine2.getText().substring(0, firstProductLine2.getText().length()-7);
        String expectedProduct = arrayList.get(0).toString(); //reversed order

        Assert.assertEquals(actualProduct, expectedProduct);

        System.out.println("----------");
        System.out.println(actualProduct);
        System.out.println(expectedProduct);
    }


}
