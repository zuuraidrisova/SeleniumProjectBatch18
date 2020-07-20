package test.day8_Alerts_Iframes_Windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class alertsPractices {

    /*
    TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfuly clicked an alert” text is displayed.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p1_information_alert_test() throws  InterruptedException{

       WebElement infoAlertButton =  driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]"));

       //Click to “Click for JS Alert” button
       infoAlertButton.click();

       //create the alert object and switch to it
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        // Click to OK button from the alert
        alert.accept();

        //locating result web element
        WebElement alertSuccessMessage = driver.findElement(By.id("result"));

        String actualMessage = alertSuccessMessage.getText();
        String expectedMessage = "You successfuly clicked an alert";

        //asserting the equality of actual vs expected success message
        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Verification passed!");

    }
    /*
    TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
     */

    @Test
    public void p2_confirmationAlert_test() throws InterruptedException{

        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        // Click to “Click for JS Confirm” button
        confirmationAlertButton.click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        //Click to OK button from the alert

        alert.accept();

        WebElement successMessage = driver.findElement(By.id("result"));

        String actualMessage = successMessage.getText();
        String expectedMessage = "You clicked: Ok";



        System.out.println("Verification Passed!");

    }

    /*
    TC #3: Information alert practice
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    3.Click to “Click for JS Prompt” button
    4.Send “hello”text to alert
    5.Click to OK button from the alert
    6.Verify “You entered:  hello” text is displayed
     */

    @Test
    public void p3_promptAlert_test9() throws  InterruptedException {

        WebElement promptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        //3.Click to “Click for JS Prompt” button
        promptButton.click();

        Alert alert = driver.switchTo().alert();

        //4.Send “hello”text to alert
        alert.sendKeys("hello");

        Thread.sleep(1000);
        //5.Click to OK button from the alert
        alert.accept();

        //6.Verify “You entered:  hello” text is displayed
        WebElement successMessage = driver.findElement(By.id("result"));

        String actualMessage = successMessage.getText();
        String expectedMessage = "You entered: hello";

        //System.out.println(actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Verification Passed!");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}

