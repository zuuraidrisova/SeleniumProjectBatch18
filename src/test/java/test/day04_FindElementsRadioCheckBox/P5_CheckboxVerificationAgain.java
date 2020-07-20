package test.day04_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P5_CheckboxVerificationAgain {

        /*
    TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(! successCheckbox.isSelected() && ! successMessage.isDisplayed()){

            System.out.println("Default value verification Passed!");
        }else{

            System.out.println("Default value verification Failed!");
        }

        successCheckbox.click();

        Thread.sleep(2000);

        if(successMessage.isDisplayed()){

            System.out.println("Success message is displayed.Verification Passed!");
        }else{

            System.out.println("Success message is NOT  displayed.Verification Failed!");
        }




    }
}
