package test.day09_TestBase_Properties_DriverUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class windowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    /*
    TC-WarmUp # : Window Handle practice
1. Create a new class called: WindowHandleWarmup
2. Create new test and make set ups
3. Go to : https://www.amazon.com
4. Copy paste the lines from below into your class
5. Create a logic to switch to the tab where Etsy.com is open
6. Assert: Title contains “Etsy”

import org.openqa.selenium.JavascriptExecutor;

((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
     */

    @Test
    public void multiple_window_test(){

        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        Set<String> windowHandles = driver.getWindowHandles();

        for(String each: windowHandles ){

            driver.switchTo().window(each);

            System.out.println("current title: "+driver.getTitle());

            if(driver.getCurrentUrl().contains("etsy")){

                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

        driver.close();

    }




}
