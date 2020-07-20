package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P10_PrintAllData {

    //• This method should simply print all the names in the List of All Orders.
    // go to "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx"
    //• Create a new TestNG test to test if the method is working as expected.
    //• Output should be like:
    //• Name1: name , City1: city
    //• Name2: name , City2: city

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        smartBearUtility.login(driver);

    }

    @Test
    public void Test(){

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[3]"));
        List<WebElement> listOfDate = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[5]"));
        List<WebElement> listOfStreet = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[6]"));
        List<WebElement> listOfCity = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));
        List<WebElement> listOfState = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[8]"));
        List<WebElement> listOfZipCodes = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[9]"));
        List<WebElement> listOfCards  = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[10]"));
        List<WebElement> listOfCardNumbers = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[11]"));
        List<WebElement> listOfExpDate = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[12]"));


        for(WebElement each: listOfNames){

           String eachNames =  each.getText();

            System.out.println(eachNames);
        }

        for(int i = 0; i < listOfCity.size(); i++){

            String output = "Street"+(i+1)+": "+listOfStreet.get(i).getText()+

                    ",City"+(i+1)+": "+listOfCity.get(i).getText()+

                    ",State"+(i+1)+ ": "+listOfState.get(i).getText();

            System.out.println(output);
        }
    }
}
