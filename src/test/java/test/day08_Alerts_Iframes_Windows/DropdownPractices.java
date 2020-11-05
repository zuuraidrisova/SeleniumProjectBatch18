package test.day08_Alerts_Iframes_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    /*
    TC#7: Cybertek “month” dropdown default value
1. Open browser
2. Go to website: http://practice.cybertekschool.com/dropdowns
3. Verify default value is always showing the current month
o Expected: If currently in June, should show June selected
     */
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void practice7_month_dropdown_default_value_test() {

        Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String actualMonthDropDown = monthDropDown.getFirstSelectedOption().getText();
        String expectedMonthDropDown = LocalDateTime.now().getMonth().name();

        System.out.println(actualMonthDropDown);
        System.out.println(expectedMonthDropDown);

        Assert.assertEquals(actualMonthDropDown.toUpperCase(), expectedMonthDropDown);

        System.out.println("Verification passed!");

        Assert.assertTrue(actualMonthDropDown.equalsIgnoreCase(expectedMonthDropDown));

        /*

TC#8: Cybertek “month” dropdown list of default values verification
1. Do both verifications in the same test
2. Verify list of months are correct as expected.
o Expected: Options should contain all 12 months of the year.
         */

        List<WebElement> actualDropdownOptions = monthDropDown.getOptions();

        List<String> actualMonthOptions = new ArrayList<>();

        for(WebElement each: actualDropdownOptions){

            actualMonthOptions.add(each.getText());

        }

        List<String> expectedMonthOptions =  Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                , "August", "September", "October", "November", "December");

        Assert.assertEquals(actualMonthOptions, expectedMonthOptions);

    }


    @AfterMethod
    public void tearDown(){

        driver.close();
    }










}
