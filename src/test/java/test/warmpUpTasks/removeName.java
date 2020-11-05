package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import utilities.smartBearUtility;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class removeName {
    /*
    TC #11 : Create a method called removeName()
1. Accepts two parameters: WebDriver, String name
2. Method will remove the given name from the list of Smartbear
3. Create a new TestNG test, and call your method.
4. Assert that your method removed the given name
     */

    public static void removeName(WebDriver driver, String name){

        String xpathForCheckboxes = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[.='"+name+"']/../td[1]";

        //String word = "example";
        //String sentence = "This is "+word+"my sentence";
        //We used similar string concat logic in our xpath above. All we do is we dynamically pass the String argument we
        //  get from our method.
        //  This way we manipulate our xpath locator. Which allows us to delete any name from list.

        //We pass our xpath in the web element locator
        WebElement dynamicCheckBox = driver.findElement(By.xpath(xpathForCheckboxes));

        //WebElement locator dynamically finds the given name's checkbox. Then we click to it.
        dynamicCheckBox.click();

        //Locating and clicking the delete button.
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //Locating all the names from the web table and storing them into a list if web elements
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));


        //Looping through the list of names, and asserting nameToBeDeleted is NOT in the list.
        for(WebElement each : allNames) {
            System.out.println(each.getText());
            Assert.assertFalse(each.getText().equals(name));

        }
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        smartBearUtility.login(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
//3. Create a new TestNG test, and call your method.
//4. Assert that your method removed the given name

    @Test
    public void removeName_test(){

        removeName(driver,"Bob Feather");

        driver.close();
    }

}
