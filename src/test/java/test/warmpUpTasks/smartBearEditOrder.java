package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class smartBearEditOrder {

    /*
    TC #10: SmartBear edit order
1. Open browser and login to SmartBear
2. Click to edit button from the right for “Steve Johns”
3. Change name to “Michael Jordan”
4. Click Update
5. Assert “Michael Jordan” is in the list
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        smartBearUtility.login(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void editOrder_test(){

        WebElement editOrder = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[4]//td[13]"));

        editOrder.click();

        WebElement customerName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));

        customerName.clear();

        customerName.sendKeys("Michael Jordan");

       WebElement updateButton =  driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));


       updateButton.click();

        List<WebElement> listOfName = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        for (WebElement eachName : listOfName) {

            if(eachName.getText().equals("Michael Jordan")) {

                Assert.assertTrue(eachName.getText().equals("Michael Jordan"));

            }
        }
        System.out.println("Verification Passed!");
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
