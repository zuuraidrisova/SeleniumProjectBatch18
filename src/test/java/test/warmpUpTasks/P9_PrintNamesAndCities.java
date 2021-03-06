package test.warmpUpTasks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

import java.util.concurrent.TimeUnit;

public class P9_PrintNamesAndCities {

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
    public void test1(){

        smartBearUtility.printNamesAndCities(driver);

    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
