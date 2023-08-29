package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseButton = driver.findElement(By.id("file-upload"));
        chooseButton.sendKeys(
                "/Users/anneconklelap/Desktop/Screen Shot 2023-08-25 at 9.25.35 AM.png");
        WebElement uploadBTN = driver.findElement(By.id("file-submit"));
        //uploadBTN.click();
        uploadBTN.submit();
        Thread.sleep(1000);
        WebElement fileUpload = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualText = BrowserUtils.getText(fileUpload);
        String expectedText = "Screen Shot 2023-08-25 at 9.25.35 AM.png";
        Assert.assertEquals(actualText, expectedText);


    }

    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement uploadButton = driver.findElement(By.id("uploadfile_0"));
        uploadButton.sendKeys("/Users/anneconklelap/Downloads/CodeFish Selenium Homework 2 (1).pdf");
        WebElement fileName = driver.findElement(By.xpath(
                "//span[@class='field_title']//b[contains(text(), 'Select file')]"));
        Thread.sleep(500);

        //uploadButton = driver.findElement(By.id("uploadfile_0"));
        String actualName = BrowserUtils.getText(fileName);
        String expectedName = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualName, expectedName);
        WebElement checkBox = driver.findElement(By.xpath("//input[@class='field_check']"));
        checkBox.click();
        WebElement button = driver.findElement(By.id("submitbutton"));
        button.click();




    }

}

