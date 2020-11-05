package test.warmpUpTasks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

import java.util.concurrent.TimeUnit;

public class P8_VerifyOrder {

    /*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        smartBearUtility.login(driver);

    }

    @Test
    public void test(){

        smartBearUtility.verifyOrder(driver,"Paul Brown");

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }


}
