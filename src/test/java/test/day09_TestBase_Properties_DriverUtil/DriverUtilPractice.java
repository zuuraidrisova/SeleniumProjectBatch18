package test.day09_TestBase_Properties_DriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.configurationReader;

public class DriverUtilPractice {

    @Test
    public void driver_practice(){

        Driver.getDriver().get("https://www.google.com");

        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));

        googleSearch.sendKeys(configurationReader.getProperty("testData")+ Keys.ENTER);
    }
}
