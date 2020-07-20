package test.day7_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P4_SelectingDateDropDownVerify {
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

        Thread.sleep(1000);

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));

        yearDropdown.selectByVisibleText("1921");

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String expectedYear = "1921";

        Thread.sleep(1000);

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        monthDropdown.selectByValue("11");

        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String expectedMonth = "December";

        Thread.sleep(1000);

        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        dayDropdown.selectByIndex(0);

        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        String expectedDay = "1";

        //asserting year, month and day values vs expected
        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertEquals(actualDay,expectedDay);


    }

    @AfterMethod
    public void tearDown(){


        driver.close();
    }
}
