package test.warmpUpTasks;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P7_BrowserCommands {

    /*
    Invoke Chrome Browser
Open URL: https://www.google.co.in/
Get Page Title name and Title length
Print Page Title and Title length on the Eclipse Console
Get page URL and verify whether it is the desired page or not
Get page Source and Page Source length
Print page Length on Eclipse Console.
Close the Browser
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.co.in/");


    }

    @Test
    public void test() throws InterruptedException{

        Thread.sleep(1000);

       String titlePage =  driver.getTitle();

        System.out.println("Title of the page: "+titlePage);
        System.out.println("The length of the title: "+titlePage.length());

        String actualCurrentURl = driver.getCurrentUrl();
        String expectedURL = "https://www.google.co.in/";

        Assert.assertEquals(actualCurrentURl, expectedURL);


        String pageSource = driver.getPageSource();

        //System.out.println("The page source is: "+pageSource);
        System.out.println("the length of page source is: "+pageSource.length());

    }

    @AfterMethod
    public void teardown () throws InterruptedException{

        Thread.sleep(1000);
        driver.close();
    }
}
