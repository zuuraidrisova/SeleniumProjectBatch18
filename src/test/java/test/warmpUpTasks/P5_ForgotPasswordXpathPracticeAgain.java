package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class P5_ForgotPasswordXpathPracticeAgain {
    /*
    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.
     */
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //a. “Home” link

        boolean isHomeDisplayed = driver.findElement(By.xpath("//a[@class='nav-link']")).isDisplayed();

        if(isHomeDisplayed){

            System.out.println("Home link is Displayed.Verification Passed!");
        }else{

            System.out.println("Home link is NOT Displayed.Verification Failed!");
        }
        System.out.println("============================================");

        //b. “Forgot password” header

        boolean isForgotPasswordDisplayed =driver.findElement(By.xpath("//h2")).isDisplayed();

        if(isForgotPasswordDisplayed){

            System.out.println("Forgot Password is Displayed.Verification Passed!");

        }else{

            System.out.println("Forgot Password is NOT Displayed.Verification Failed!");
        }

        System.out.println("============================================");

        //c. “E-mail” text

        boolean isEmailDisplayed = driver.findElement(By.xpath("//label[@for='email']")).isDisplayed();

        if(isEmailDisplayed){

            System.out.println("Email Text is Displayed.Verification Passed!");

        }else{

            System.out.println("Email Text is NOT Displayed.Verification Failed!");
        }

        System.out.println("============================================");

        //d. E-mail input box

        boolean isEmailInputBoxDisplayed = driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();

        if(isEmailInputBoxDisplayed){

            System.out.println("Email input box is Displayed.Verification Passed!");
        }else{

            System.out.println("Email Input Box is NOT Displayed.Verification Failed!");
        }

        System.out.println("============================================");

        //e. “Retrieve password” button

        boolean isRetrievePasswordDisplayed = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).isDisplayed();

        if(isRetrievePasswordDisplayed){

            System.out.println("Retrieve Password Button is Displayed.Verification Passed!");
        }else{

            System.out.println("Retrieve Password Button is NOT Displayed.Verification Failed!");

        }

        System.out.println("============================================");

        //f. “Powered by Cybertek School” text

        boolean isPoweredByCybertekSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']")).isDisplayed();

        if(isPoweredByCybertekSchool){

            System.out.println("Powered By Cybertek School Text is Displayed.Verification Passed!");
        }else{

            System.out.println("Powered By Cybertek School Text is NOT Displayed.Verification Failed!");
        }

        driver.close();

    }
}
