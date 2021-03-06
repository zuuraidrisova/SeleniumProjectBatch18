package test.day04_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P4_Cybertek_Checkboxes {
    /*
    Practice: Cybertek Checkboxes
1. Go to http://practice.cybertekschool.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/checkboxes");

        //  2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        if(!checkbox1.isSelected()){

            System.out.println("Checkbox 1 is not selected by default.Verification Passed!");
        }else{

            System.out.println("Checkbox 1 is selected by default.Verification Failed! ");
        }

        //        3. Confirm checkbox #2 is SELECTED by default.

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(checkbox2.isSelected()){

            System.out.println("Checkbox 2 is selected by default.Verification Passed! ");
        }else{

            System.out.println("Checkbox 2 is not selected by default.Verification Failed!");
        }

        System.out.println("==================================================");

        //        4. Click checkbox #1 to select it.
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();

        //        5. Click checkbox #2 to deselect it.
        driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();

        //        6. Confirm checkbox #1 is SELECTED.
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));

        if(checkBox1.isSelected()){

            System.out.println("CheckBox 1 is selected this time.Verification Passed!");
        }else{

            System.out.println("CheckBox 2 is not selected.Verification Failed!");
        }

        //        7. Confirm checkbox #2 is NOT selected.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(! checkBox2.isSelected()){

            System.out.println("CheckBox 2 is NOT selected.Verification Passed!");
        }else{

            System.out.println("CheckBox 1 is  selected.Verification Failed!");
        }

       driver.close();


    }
}
