package test.officeHours.day03_DataProviderTestNG_Example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExcelReader;

public class DataProviderExample {

    WebDriver driver = Driver.getDriver();

    @DataProvider
    public Object[][] testData() {

        return new Object[][]{
                {"storemanager85", "UserUser123", "Dashboard"},
                {"salesmanager110", "UserUser123", "Dashboard"}
        };
    }

    @Test(dataProvider = "testData")
    public void login(String username, String password, String title) throws InterruptedException{

        driver.get("https://qa1.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys(username);

        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);

       Thread.sleep(2000);

        Assert.assertTrue(driver.getTitle().equals(title));

    }


    @DataProvider
    public Object[][] testDataFromExcel() {

        ExcelReader excelUtil = new ExcelReader("VytrackTestUsers.xlsx", "QA1-short");

        return excelUtil.getDataArray();

    }

    //execute   username    password    firstname   lastname    result
    @Test(dataProvider = "testDataFromExcel")
    public void loginTestWithExcel(String execute, String username, String password,
       String firstname, String lastname, String result) throws InterruptedException {

        if (execute.equalsIgnoreCase("y")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);

            driver = new ChromeDriver(chromeOptions);
            driver.get("https://qa1.vytrack.com/user/login");
            driver.findElement(By.id("prependedInput")).sendKeys(username);
            driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
            Thread.sleep(3000);
            Assert.assertEquals(driver.getTitle(), "Dashboard");

        } else {
            throw new SkipException("Test skipped, because it's says N in your excel file!");
        }
    }


    @AfterMethod
    public void tearDown(){

        if(driver != null){

            driver.close();
        }
    }


}
