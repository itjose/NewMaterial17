package ActionsClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions {

    @Test
    public void practiceDragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(1000);
        WebElement box = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));

        String actualTextBefore = box.getText().trim();
        String expectedTextBefore = "Drop here";
        Assert.assertEquals(actualTextBefore, expectedTextBefore);

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, box).perform();
        Thread.sleep(500);
        box = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));
        String actualAfterMessage = BrowserUtils.getText(box);
        String expectedMessage = "Dropped!";

        Assert.assertEquals(actualAfterMessage, expectedMessage);

        String actualBoxColorAfter = box.getCssValue("background-color");
        String expectedColorAfter = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBoxColorAfter, expectedColorAfter);



    }

    @Test

    public void clickAndHoldPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(1000);
        WebElement box = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));

        String actualTextBefore = box.getText().trim();
        String expectedTextBefore = "Drop here";

        Assert.assertEquals(actualTextBefore, expectedTextBefore);

        WebElement acceptBTN = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions = new Actions(driver);
        actions.click(acceptBTN).perform();

        Thread.sleep(3000);
        box = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));

        WebElement notAcceptButton = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        actions.clickAndHold(notAcceptButton).moveToElement(box).release().perform();
        Thread.sleep(500);

        String actualTextAfter = BrowserUtils.getText(box);
        String expectedTextAfter = "Drop here";

        Assert.assertEquals(actualTextAfter, expectedTextAfter);

    }



}
