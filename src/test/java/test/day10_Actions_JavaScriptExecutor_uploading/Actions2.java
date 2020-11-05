package test.day10_Actions_JavaScriptExecutor_uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import org.openqa.selenium.interactions.Actions;

public class Actions2 {


    @Test
    public void hoover_over_test() throws InterruptedException{

        Driver.getDriver().get("https://www.amazon.com");

        //1- Create the instance of Actions class
        //2- Pass the current driver instance
        //3- Locate the web element to hover over
        //4- Using actions, hover over to the Language options

        Actions actions = new Actions(Driver.getDriver());

        WebElement languageOptions = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        Thread.sleep(2000);

        actions.moveToElement(languageOptions).perform();

        Driver.closeDriver();

    }


}
