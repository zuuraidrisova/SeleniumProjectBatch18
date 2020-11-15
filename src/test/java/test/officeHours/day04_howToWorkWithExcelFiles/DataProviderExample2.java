package test.officeHours.day04_howToWorkWithExcelFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExcelReader;
import utilities.configurationReader;
import org.testng.annotations.DataProvider;

public class DataProviderExample2 {

    @Test
    public void loginTestVyTrack() throws InterruptedException{

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        //WebDriverWait is a class which helps us put wait times explicitly,
        // we have to pass driver instance and timeUnits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));

        usernameInput.sendKeys(configurationReader.getProperty("storeManager_username"));
        passwordInput.sendKeys(configurationReader.getProperty("storeManager_password")+ Keys.ENTER);

        //we tell exactly what to wait for
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");

        Thread.sleep(2000);

        Driver.closeDriver();

    }

    //DataProvider is to achieve data driven testing, testing driven by data
    @DataProvider
    public Object[][] testData(){

        return new Object[][]{

                {"storemanager85", "UserUser123", "Dashboard"},
                {"salesmanager110", "UserUser123", "Dashboard"}

        };

    }



    @Test(dataProvider = "testData")
    public void loginTestVyTrackWithDataProvider(String username, String password, String expectedTitle)
            throws InterruptedException{


        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        //WebDriverWait is a class which helps us put wait times explicitly,
        // we have to pass driver instance and timeUnits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);

        //we tell exactly what to wait for
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

        Thread.sleep(2000);

        Driver.closeDriver();


    }


    @DataProvider
    public Object [][] testDataFromExcel(){

        ExcelReader excel = new ExcelReader("VytrackTestUsers.xlsx", "QA1-short");

        return excel.getDataArray();

    }

    //below code is failing

    @Test(dataProvider = "testDataFromExcel")
    public void loginTestVyTrackWithDataProviderFromExcel(String execute, String username,
     String password, String firstName, String lastName, String expectedTitle)
            throws InterruptedException{

        if(execute.equalsIgnoreCase("y")) {

            Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

            //WebDriverWait is a class which helps us put wait times explicitly,
            // we have to pass driver instance and timeUnits
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

            WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
            WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));

            usernameInput.sendKeys(username);
            passwordInput.sendKeys(password + Keys.ENTER);

            //we tell exactly what to wait for
            wait.until(ExpectedConditions.titleIs(expectedTitle));

            Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

        }else{

            throw new SkipException ("test skipped because it says n instead of y");

        }

//        Thread.sleep(2000);
//
//        Driver.closeDriver();


    }



}
