package test.day06_TestNG_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class DropDownsPractices {
    /*
TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException{

        //it does not matter where you put after or before methods
        // because they  run based on annotations.. not like java top to bottom
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void test1_default_value_verification(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id ='dropdown']")));
        String actualDefaultValueOfSimpleDropDown = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultValueOfSimpleDropDown = "Please select an option";

        Assert.assertEquals(actualDefaultValueOfSimpleDropDown,expectedDefaultValueOfSimpleDropDown);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id ='state']")));

        String actualStateDropDown = stateDropDown.getFirstSelectedOption().getText();
        String expectedStateDropDown = "Select a State";

        Assert.assertEquals(actualStateDropDown,expectedStateDropDown);

    }

    @Test
    public void test2_stateDropdown_verification() throws InterruptedException{
  /* these lines have already been handled in beforeMethod
  TC #2: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
these lines above have already been handled in beforeMethod
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
         */

        //locating state dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id ='state']")));

        Thread.sleep(1000);

        //select Illinois
        //selecting using  .selectByValue(); method ==> expect the attribute value
        stateDropdown.selectByValue("IL");

        Thread.sleep(1000);

        //Select Virginia
        //selecting using .selectByVisibleText(); method ==> expect the actual literal text
        stateDropdown.selectByVisibleText("Virginia");

        Thread.sleep(1000);

        //  Select California
        //selecting using .selectByIndex(); method ==> expect index number of an option
        stateDropdown.selectByIndex(5);

        // Verify final selected option is California.

        String expectedOption = "California";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption);

    }

}
