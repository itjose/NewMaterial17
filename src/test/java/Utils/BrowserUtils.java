package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class BrowserUtils {

    public static String getText(WebElement element){

        return element.getText().trim();
    }

    public static void selectBy(WebElement location, String value, String methodName){

        Select select = new Select(location);

        switch (methodName){

            case "text":
                select.selectByVisibleText(value);
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your method name is Not matching with text, value, index");

        }

    }

    public static String getTitleWithJS(WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }
    public static void clickWithJS(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);

    }

    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }

    public static void switchWindow(WebDriver driver, String title){
        Set<String> allPagesId = driver.getWindowHandles();
        for (String pageId : allPagesId){
            driver.switchTo().window(pageId);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }




}
