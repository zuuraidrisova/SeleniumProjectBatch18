package test.warmpUpTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class P5_ForgotPasswordWithXpath {
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

        boolean HomeLinkIsDisplayed = driver.findElement(By.xpath("/html/body/nav/ul/li/a")).isDisplayed();

        System.out.println(HomeLinkIsDisplayed);

        //a.“Home” link
        if(HomeLinkIsDisplayed){

            System.out.println("Home Link is displayed.Verification Passed!");
        }else{

            System.out.println("Home Link is NOT displayed.Verification Failed!");
        }

        System.out.println("=================================");

        //b. “Forgot password” header

        Boolean HeaderIsDisplayed = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h2")).isDisplayed();

        System.out.println(HeaderIsDisplayed);

        if(HeaderIsDisplayed){

            System.out.println("Forgot Password Header is displayed.Verification Passed!");
        }else{

            System.out.println("Forgot Password Header is NOT  displayed.Verification Failed!");
        }

        System.out.println("=================================");

        //c. “E-mail” text

        boolean EmailTextIsDisplayed = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div/label")).isDisplayed();

        System.out.println(EmailTextIsDisplayed);

        if(EmailTextIsDisplayed){

            System.out.println("Email Text is Displayed. Verification Passed!");
        }else{

            System.out.println("Email Text is NOT Displayed. Verification Failed!");
        }

        System.out.println("=================================");

        //d. E-mail input box

        boolean EmailInputBoxIsDisplayed = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div/label")).isDisplayed();

        System.out.println(EmailInputBoxIsDisplayed);

        if(EmailInputBoxIsDisplayed){

            System.out.println("Email Input Box is Displayed.Verification Passed!");
        }else{

            System.out.println("Email Input Box is NOT  Displayed.Verification Failed!");
        }

        System.out.println("=================================");

        //“Retrieve password” button

        boolean RetrievePasswordDisplay = driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button/i")).isDisplayed();

        System.out.println(RetrievePasswordDisplay);

        if(RetrievePasswordDisplay){

            System.out.println("Retrieve Password Button is Displayed.Verification Passed!");
        }else{

            System.out.println("Retrieve Password Button is NOT Displayed.Verification Failed!");
        }

        System.out.println("=================================");


        //f. “Powered by Cybertek School” text

       boolean PoweredByCybertekSchoolDisplayed =  driver.findElement(By.xpath("html/body/div/div[3]/div/div")).isDisplayed();

        System.out.println(PoweredByCybertekSchoolDisplayed);

        if(PoweredByCybertekSchoolDisplayed){

            System.out.println("Powered By Cybertek School Text is Displayed.Verification Passed!");
        }else{

            System.out.println("Powered By Cybertek School Text is NOT  Displayed.Verification Failed!");

        }

        driver.close();


    }
}
