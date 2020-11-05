package test.day06_TestNG_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestngSeleniumPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //open browser, go to : https://www.google.com
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");

    }

    @Test (priority = 1)
    public void google_search_title_verification(){

        // search apple

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Apple");

        driver.findElement(By.xpath("//input[@name='btnK']")).click();

        //verify title contains apple
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

    @Test (priority = 2)
    public void google_title_text(){
        //open browser, go to : https://www.google.com
        //verify title: Google

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        //then we do assertions
       // Assert.assertTrue(actualTitle.equals(expectedTitle));

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        // close browser
        Thread.sleep(2000);

        driver.close();
    }


}
