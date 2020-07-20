package test.day06_TestNG_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC5_SelectingValueFromNonSelectDropdown {

    /*
    TC #5: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    @Test
    public void test() throws InterruptedException{

       WebElement selectWebsite =  driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));

        selectWebsite.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='dropdown-item'][4]")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
