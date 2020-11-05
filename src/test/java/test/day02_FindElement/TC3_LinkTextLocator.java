package test.day02_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_LinkTextLocator {
    /*
    TC #3: Back and forth navigation
    1-Open a chrome browser
    2-Go to: https://google.com
    3-Click to Gmail from top right.
    4-Verify title contains:Expected: Gmail
    5-Go back to Google by using the .back();
    6-Verify title equals:
            Expected: Google
     */

    public static void main(String[] args) {

        /*
        LinkText is one of the 8 locators in Selenium

           2.linkText ==> it allows user to locate links by their text
                Only works only links,
                i know it is link by <a> webelement
                <a href = "https://www.google.com"> TEXT HERE </a>

         */
        //creates a connection between selenium and browser
        WebDriverManager.chromedriver().setup();

        //opens chrome driver
        WebDriver driver = new ChromeDriver();

        //maximizes the screen
        driver.manage().window().maximize();

        //opens the given url
        driver.get("https://google.com");

        //click to Gmail link from top right
        driver.findElement(By.linkText("Gmail")).click();

        // 4-Verify title contains:Expected: Gmail
        String actualGmailTitle = driver.getTitle();
        String expectedGmailTitle = "Gmail";


        if(actualGmailTitle.contains(expectedGmailTitle)){

            System.out.println("Gmail Title Verification PASSED");

        }else{

            System.out.println("Gmail Title Verification FAILED");

        }

        // 5-Go back to Google by using the .back();
        driver.navigate().back();

        //   6-Verify title equals: Expected: Google
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if(actualTitle.equals(expectedTitle)){

            System.out.println("Google Page Title Verification PASSED");

        }else{

            System.out.println("Google Page Title Verification FAILED");
        }

    }
}
