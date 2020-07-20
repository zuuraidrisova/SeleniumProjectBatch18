package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P6_DataTesting {
    /*
 Invoke Google Chrome Browser
Open URL: https://www.testandquiz.com/selenium/testing.html
Select the option "Database Testing" from the drop-down menu
Close the browser
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.testandquiz.com/selenium/testing.html");
    }

    @Test
    public void  test() throws InterruptedException{
        //Select the option "Database Testing" from the drop-down menu

       WebElement testingDropdown =  driver.findElement(By.xpath("//select[@id='testingDropdown']"));

        Select databaseTesting = new Select(testingDropdown);

        Thread.sleep(1000);

        databaseTesting.selectByValue("Database");

        String actualDatabaseTestingOption = databaseTesting.getFirstSelectedOption().getText();
        String expectedDatabaseTestingOption = "Database Testing";

        Assert.assertEquals(actualDatabaseTestingOption, expectedDatabaseTestingOption);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(1000);
        driver.close();
    }



}
