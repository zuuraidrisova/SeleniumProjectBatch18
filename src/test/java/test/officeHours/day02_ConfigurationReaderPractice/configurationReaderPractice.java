package test.officeHours.day02_ConfigurationReaderPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configurationReaderPractice {

    private static Properties properties;

    WebDriver driver;

    static {

        try {

            properties = new Properties();

            String path = "src/test/resources/config.properties";

            FileInputStream file = new FileInputStream(path);

            properties.load(file);

            file.close();

        } catch (IOException e) {


        }

    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }

    @Test
    public void loginTest() throws InterruptedException{

        String browser =  getProperty("browser");
        String url = getProperty("url");

        driver = WebDriverFactory.getDriver(browser);

        driver.get(url);

        Thread.sleep(2000);

        String title =  driver.getTitle();

        System.out.println(title);

        String username = getProperty("username");
        String password = getProperty("password");
        driver.findElement(By.id("prependedInput")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Page Title is not correct");

        System.out.println("Title Verification passed!");
    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }
}
