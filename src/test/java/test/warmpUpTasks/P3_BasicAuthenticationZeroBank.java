package test.warmpUpTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_BasicAuthenticationZeroBank {
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

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");


        driver.findElement(By.name("user_login")).sendKeys("username");

        driver.findElement(By.name("user_password")).sendKeys("password");

        driver.findElement(By.name("submit")).click();

       //6. Verify username is displayed on the page
        String actualUsername = driver.findElement(By.linkText("username")).getText();
        String expectedUsername = "username";

        if(actualUsername.equals(expectedUsername)){

            System.out.println("Username Verification PASSED");
        }else{

            System.out.println("Username Verification FAILED");
        }

        //7. Verify the title Zero – Account Summary

        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        System.out.println(actualTitle);

        if(actualTitle.equalsIgnoreCase(expectedTitle)){

            System.out.println("Zero Bank Title Verification PASSED!");
        }else{

            System.out.println("Zero Bank Title Verification FAILED!");
        }

        //8. Verify the link Account Summary’s href value contains: “account-summary”

        String actualAttributeValue = driver.findElement(By.linkText("Account Summary")).getAttribute("href");
        String expectedAttributeValue = "account-summary";

        if(actualAttributeValue.contains(expectedAttributeValue)){

            System.out.println("Attribute Value Verification PASSED");
        }else{

            System.out.println("Attribute Value Verification FAILED");
        }




       driver.close();



    }
}
