package test.officeHours.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonTitleVerification {


        WebDriver driver;
        SoftAssert softAssert;
        @BeforeClass
        public void classSetup(){
            System.out.println("Some class setup");
        }
        //to run before every test method
        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();//to open chrome browser for test
            softAssert = new SoftAssert();
        }
        @Test(description = "Test for Google", priority = 1)
        public void test() {
            driver.get("http://google.com");
            //soft assertions
            softAssert.assertEquals(driver.getTitle(), "Google23");
            softAssert.assertEquals(driver.getTitle(), "Google21");
            softAssert.assertEquals(driver.getTitle(), "Google1231");
            System.out.println("Page title :: "+driver.getTitle());
            softAssert.assertAll();//regardless on miss matching assertions, test execution will continue until this point
        }
        @Test(description = "Test for Amazon", priority = 2)
        public void amazonTest(){
            driver.get("http://amazon.com");
            System.out.println("Before assertion");
            Assert.assertTrue(driver.getTitle().contains("Amazon"));
            System.out.println("After assertion");
        }
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

}
