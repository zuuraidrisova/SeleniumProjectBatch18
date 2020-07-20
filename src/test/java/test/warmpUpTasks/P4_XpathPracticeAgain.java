package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class P4_XpathPracticeAgain {
        /*
    TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

       // 3. Click to “Add Element” button
       // 4. Verify “Delete” button is displayed after clicking.

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

       boolean DeleteButtonDisplayed =  driver.findElement(By.xpath("//button[@class='added-manually']")).isDisplayed();

        System.out.println(DeleteButtonDisplayed);

        if(DeleteButtonDisplayed){

            System.out.println("Delete Button is Displayed.Verification Passed!");

        }else{

            System.out.println("Delete Button is NOT Displayed.Verification Failed!");
        }

        System.out.println("=================================================");

       // 5. Click to “Delete” button.
       // 6. Verify “Delete” button is NOT displayed after clicking.

        driver.findElement(By.xpath("//button[@class='added-manually']")).click();

        boolean DeleteButtonNotDisplayed = driver.findElement(By.xpath("//div[@class='container']")).isDisplayed();

        if(DeleteButtonDisplayed){

            System.out.println("Delete Button NOT Displayed.Verification PASSED!");
        }else{

            System.out.println("Delete Button IS Displayed.Verification FAILED!");
        }

        driver.close();


    }
}
