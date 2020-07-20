package test.day4_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P5_CheckboxVerificationPractice {

    /*
    TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Success – Check box is not checked” message is NOT displayed.

        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        if(! checkBox.isSelected()){

            System.out.println("Success - Check Box is NOT checked.Verification Passed!");

        }else{

            System.out.println("Success - Check Box is checked.Verification Failed!");
        }

        String checkBoxText = checkBox.getText();

        if(checkBoxText.isEmpty()){

            System.out.println("“Message is NOT displayed.Verification Passed!");

        }else{

            System.out.println("Message is displayed.Verification Failed!");
        }

        //4. Click to checkbox under “Single Checkbox Demo” section

        checkBox.click();

        //5. Verify “Success – Check box is checked” message is displayed.

        if(checkBox.isSelected()){

            System.out.println("Success – Check box is checked.Verification Passed!");
        }else{

            System.out.println("Success – Check box is NOT checked.Verification Failed!");
        }

       // String actualMessage = checkBox.getText();
       // String expectedMessage = "Success – Check box is checked";

        //System.out.println(actualMessage);

        if(checkBox.isDisplayed()){

            System.out.println("Message is displayed.Verification Passed!");
        }else{

            System.out.println("Message is NOT displayed.Verification Failed!");
        }

        driver.close();


    }
}
