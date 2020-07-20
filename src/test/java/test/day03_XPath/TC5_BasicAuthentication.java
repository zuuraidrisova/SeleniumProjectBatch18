package test.day03_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class TC5_BasicAuthentication {
    /*
    TC #5: Basic authentication Zero Bank
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click sign in button
6. Verify username is displayed on the page
7. Verify the title Zero – Account Summary
8. Verify the link Account Summary’s href value contains: “account-summary”
Print out results in validation formats
     */

    public static void main(String[] args) {

       WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Enter username: username
        //4. Enter password: password
        //5. Click sign in button

        driver.findElement(By.id("user_login")).sendKeys("username");

        driver.findElement(By.id("user_password")).sendKeys("password");

        driver.findElement(By.name("submit")).click();

        //6. Verify username is displayed on the page
        String actualUsername = driver.findElement(By.className("wrapper")).getText();
        String expectedUsername = "username";

        System.out.println(actualUsername);

        if(actualUsername.contains(expectedUsername)){

            System.out.println("username display verification Passed!");
        }else{

            System.out.println("username display verification Failed!");
        }
        boolean displayed =  driver.findElement(By.className("wrapper")).isDisplayed();

        //7. Verify the title Zero – Account Summary

        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        System.out.println(actualTitle);

        if(actualTitle.equalsIgnoreCase(expectedTitle)){

            System.out.println("Zero Bank Title Verification Passed!");
        }else{

            System.out.println("Zero Bank Title Verification Failed!");
        }

        //8. Verify the link Account Summary’s href value contains: “account-summary”

        String actualAttributeInValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedAttributeInValue = "account-summary";

        System.out.println("Attribute value is: "+actualAttributeInValue);

        if(actualAttributeInValue.contains(expectedAttributeInValue)){

            System.out.println("Attribute value verification Passed!");
        }else{

            System.out.println("Attribute value verification Failed!");

        }

       driver.close();

    }
}
