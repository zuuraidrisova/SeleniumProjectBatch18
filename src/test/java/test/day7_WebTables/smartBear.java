package test.day7_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

public class smartBear {

   WebDriver driver;

   @BeforeMethod
    public void setUp(){


       driver = WebDriverFactory.getDriver("chrome");

       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

       smartBearUtility.login(driver);

       driver.manage().window().maximize();

    }

   @Test
    public void test(){

      WebElement Bob =  driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr/td[.='Bob Feather']"));

     String actualName =  Bob.getText();
     String expectedInName = "Bob";

       Assert.assertTrue(actualName.contains(expectedInName));

       System.out.println("Verification passed!");
   }

   @AfterMethod
   public void tearDown(){

       driver.close();
   }
}
