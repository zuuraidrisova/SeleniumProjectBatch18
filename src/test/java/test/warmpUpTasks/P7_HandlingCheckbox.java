package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P7_HandlingCheckbox {

    /*
Invoke a Google chrome browser.
Navigate to the website in which you handle the checkbox.
Select the 'Senior Citizen' checkbox from the spicejet website.
Close the driver.
     */

    WebDriver driver;


    @BeforeMethod
    public void setUp() throws  InterruptedException{

       driver = WebDriverFactory.getDriver("chrome");

       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       driver.get("https://www.spicejet.com/");

       Thread.sleep(1000);
    }

    @Test
    public void Test() throws InterruptedException{

        //Select the 'Senior Citizen' checkbox from the spicejet website.

        WebElement seniorCitizenCheckbox =  driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']"));

        Thread.sleep(1000);

        seniorCitizenCheckbox.click();

        Assert.assertTrue(seniorCitizenCheckbox.isSelected());

        Thread.sleep(1000);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        Thread.sleep(1000);

        driver.close();
    }
}
