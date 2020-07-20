package test.day6_TestNG_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC3_SelectingADate {
    /*
TC #3: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select “December 1st, 1921” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //3. Select “December 1st, 1921” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
    @Test
    public void test1() throws InterruptedException{

        Select yearDropdown =  new Select(driver.findElement(By.xpath("//select[@id='year']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("1921");

        String expectedYearOption = "1921";
        String actualYearOption = yearDropdown.getFirstSelectedOption().getText();

        Thread.sleep(2000);

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        //Select month using : value attribute
        monthDropdown.selectByValue("11");

        String expectedMonthOption = "December";
        String actualMonthOption = monthDropdown.getFirstSelectedOption().getText();

        Thread.sleep(2000);

        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select day using : index number
        dayDropdown.selectByIndex(0);

        String expectedDayOption = "1";
        String actualDayOption = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYearOption,expectedYearOption);

        Assert.assertEquals(actualMonthOption,expectedMonthOption);

        Assert.assertEquals(actualDayOption, expectedDayOption);

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
