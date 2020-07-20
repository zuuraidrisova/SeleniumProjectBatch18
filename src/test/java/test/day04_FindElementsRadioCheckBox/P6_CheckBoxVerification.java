package test.day04_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P6_CheckBoxVerification {

    public static void main(String[] args) {

        /*
TC #3: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Check All” button text is “Check All”
        String actualButtonText = driver.findElement(By.xpath("//input[@class='btn btn-primary']")).getAttribute("value");
        String expectedButtonText = "Check All";

        System.out.println(actualButtonText);

        if(actualButtonText.equals(expectedButtonText)){

            System.out.println("Button text verification Passed!");
        }else{

            System.out.println("Button text verification Failed!");
        }

        //4. Click to “Check All” button

        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

        //5. Verify all check boxes are checked
        boolean checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
        boolean checkBox3 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected();
        boolean checkBox4 = driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).isSelected();
        boolean checkBox5 = driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected();

        if(checkBox2 && checkBox3 && checkBox4 && checkBox5){

            System.out.println("All check boxes are selected.Verification Passed!");
        }else{

            System.out.println("All check boxes are not selected.Verification Failed!");

        }
        //6. Verify button text changed to “Uncheck All”

        String actualUnCheckAllButtonText = driver.findElement(By.xpath("//input[@class='btn btn-primary']")).getAttribute("value");
        String expectedUnCheckAllButtonText = "Uncheck All";

        if(actualUnCheckAllButtonText.equals(expectedUnCheckAllButtonText)){

            System.out.println("Uncheck All button text verification Passed!");
        }else{

            System.out.println("Uncheck All button text verification Failed!");
        }


    }
}
