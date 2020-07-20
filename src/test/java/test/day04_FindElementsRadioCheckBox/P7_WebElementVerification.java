package test.day04_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P7_WebElementVerification {
    /*
TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times

        for(int i = 0; i < 50; i++) {

            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        }
        //4. Verify 50 “Delete” button is displayed after clicking.

        List<WebElement>listOfDeleteButton = driver.findElements(By.xpath("//button[.='Delete']"));

        System.out.println("Number of Delete buttons: "+listOfDeleteButton.size());

        //5. Click to ALL “Delete” buttons to delete them.

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));

        for(WebElement eachDelete : deleteButtons){

            eachDelete.click();
        }
       //6. Verify “Delete” button is NOT displayed after clicking.

        String allTextsOnPage = driver.findElement(By.xpath("//div[@class='container']")).getText();
        String containDelete = "Delete";

        if(! allTextsOnPage.contains(containDelete)){

            System.out.println("Delete Button is not displayed.Verification passed!");
        }else{

            System.out.println("Delete Button is displayed.Verification failed!");

        }


    }
}
