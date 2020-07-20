package test.day10_Actions_JavaScriptExecutor_uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JSExecutor {


    @Test
    public void jsExecutor_test() throws  InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor)Driver.getDriver();

        Thread.sleep(4000);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",cybertekSchoolLink);

    }
}
