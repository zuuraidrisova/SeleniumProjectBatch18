package test.day07_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P3_smartBearSoftwareOrderVerification {
    /*
    TC#3: Smartbear software order verification
1. Open browser and login to Smartbear software
 and go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
2. Click on View all orders
3. Verify Susan McLaren has order on date “01/05/2010”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test(){
        //2. Click on View all orders
        //3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        WebElement susanDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
        //WebElement susanDate = driver.findElement(By.xpath("//tbody//tr[6]/td[5]"));

        String expectedDate = "01/05/2010";
        String actualDate = susanDate.getText();

        Assert.assertEquals(actualDate,expectedDate);

        System.out.println("Verification passed!");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
