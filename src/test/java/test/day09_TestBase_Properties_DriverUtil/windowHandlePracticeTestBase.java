package test.day09_TestBase_Properties_DriverUtil;

import test.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHandlePracticeTestBase extends TestBase {


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

    }
}
