package test.day6_TestNG_DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4_selectingFromMultipleDropdown {

    /*
    TC #4: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    //3. Select all the options from multiple select dropdown.
    //4. Print out all selected values.
    //5. Deselect all values.

    @Test
    public void test() throws InterruptedException{

        Select languagesDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        Thread.sleep(1000);
        languagesDropdown.selectByValue("java");

        Thread.sleep(1000);
        languagesDropdown.selectByVisibleText("JavaScript");

        Thread.sleep(1000);
        languagesDropdown.selectByIndex(2);

        Thread.sleep(1000);
        languagesDropdown.selectByValue("python");

        Thread.sleep(1000);
        languagesDropdown.selectByVisibleText("Ruby");

        Thread.sleep(1000);
        languagesDropdown.selectByIndex(5);

        List<WebElement> listOfLanguages = languagesDropdown.getAllSelectedOptions();

        for(WebElement each: listOfLanguages){

            String eachLanguage = each.getText();

            System.out.println(eachLanguage);
        }


        Thread.sleep(1000);
        languagesDropdown.deselectAll();



    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }



}
