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

public class smartBearDeleteOrder {
    /*
   TC #9: SmartBear delete order
1. Open browser and login to SmartBear
2. Delete “Mark Smith” from the list
3. Assert it is deleted from the list
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
    public void deleteFromSmartBear_test(){

        WebElement markSmith = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[3]/td[1]"));

        markSmith.click();

        WebElement deleteButton =  driver.findElement(By.name("ctl00$MainContent$btnDelete"));

        deleteButton.click();

        List<WebElement> listOfName = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        for (WebElement eachName : listOfName) {

                Assert.assertTrue(! eachName.getText().equals("Mark Smith"));

        }
        System.out.println("Verification Passed!");

    }

    @AfterMethod
    public void tearDown(){

       driver.close();
    }
}
