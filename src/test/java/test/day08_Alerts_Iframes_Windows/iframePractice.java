package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class iframePractice {
    /*
    TC #4 : Iframe practice
1. Create a new class called: IframePractice
2. Create new test and make set ups
3. Go to: http://practice.cybertekschool.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/iframe");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void iframe_test(){

        //locating iframe as a web element, then switch to it
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        driver.switchTo().frame(iframe);

        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //WE HAVE TO SWITCH BACK TO DEFAULT HTML TO BE ABLE TO LOCATE ANYTHING IN THERE
        driver.switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        WebElement h3Text = driver.findElement(By.xpath("//h3"));

        String actualText = h3Text.getText();
        String expectedInText = "TinyMCE WYSIWYG Editor";
        Assert.assertTrue(h3Text.isDisplayed());
        Assert.assertTrue(actualText.contains(expectedInText));

        System.out.println("Verifications passed!");


    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }


}
