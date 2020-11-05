package test.day10_Actions_JavaScriptExecutor_uploading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading {

    @Test
    public void uploading_test() throws InterruptedException{

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));

        Thread.sleep(2000);

        chooseFile.sendKeys("/Users/zuura/Desktop/test");

        WebElement fileUpload  =  Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));

        fileUpload.click();

        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        System.out.println("Assertion pass!");

        Driver.closeDriver();
    }
}
