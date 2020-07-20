package test.day7_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_SmartBearSoftwareLinkVerification {
    /*
TC #1: Smartbear software link verification
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page
    @Test
    public void test1() {

        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

        userNameInput.sendKeys("Tester");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        passwordInput.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        loginButton.click();

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

       int actualNumberOfLinks = listOfLinks.size();
       int expectedNumberOfLinks = 6;

        Assert.assertTrue(actualNumberOfLinks == expectedNumberOfLinks);

        for (WebElement eachLink: listOfLinks){

            String eachLinkText = eachLink.getText();

            System.out.println("Text of each link on the Page: "+eachLinkText);
        }
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
