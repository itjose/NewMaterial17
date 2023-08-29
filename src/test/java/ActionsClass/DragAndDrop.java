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

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxText = BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxText = "... Or here.";
        Assert.assertEquals(actualOrangeBoxText, expectedOrangeBoxText);
        String actualColorBox = orangeBox.getCssValue("background-color");
        String expectedColorBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorBox, expectedColorBox);

        WebElement dragBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragBox, orangeBox).perform();

        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));

        Thread.sleep(3000);
        String actualAfterDragText = BrowserUtils.getText(orangeBox);
        String expectedAfterDrag = "You did great!";

        Assert.assertEquals(actualAfterDragText, expectedAfterDrag);

    }

    @Test
    public void DragAndDropPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBoxColor = blueBox.getCssValue("background-color");
        String expectedBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBoxColor, expectedBoxColor);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, blueBox).perform();

        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Thread.sleep(500);
        String afterDragText = BrowserUtils.getText(blueBox);
        String expectedDragText = "You did great!";

        Assert.assertEquals(afterDragText, expectedDragText);


    }

}
