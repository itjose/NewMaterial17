package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathHealthProject {

     /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
           */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement appointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
                    appointmentButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        firstName.sendKeys("John Doe");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='txt-password']"));
        lastName.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement admissionBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));

        if(admissionBox.isDisplayed() && !admissionBox.isSelected()){
            admissionBox.click();
        }
        System.out.println(admissionBox.isSelected() ? "admission selected" : "admission not selected");

        WebElement medicaidRadioButton = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaidRadioButton.click();

        WebElement calendar = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        calendar.sendKeys("27/03/2019");

        WebElement commentArea = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        commentArea.sendKeys("I love Java.");

        WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointmentButton.click();

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(), confirmation)]"));
        String actualHeader = header.getText();
        System.out.println(header.getText());
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header Passed" : "Header Failed");

        WebElement facilityHeader = driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facilityHeader.getText());

        WebElement readmission = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(readmission.getText());

        WebElement program = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(program.getText());

        WebElement date = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(date.getText());

        WebElement comment = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(comment.getText());

        WebElement goHomeButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goHomeButton.click();

        Thread.sleep(2000);

        System.out.println(driver.getCurrentUrl());
        driver.close();








    }
}
