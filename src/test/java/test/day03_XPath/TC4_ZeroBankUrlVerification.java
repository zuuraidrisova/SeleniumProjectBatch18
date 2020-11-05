package test.day03_XPath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_ZeroBankUrlVerification {
    /*
    TC #4: Zero Bank URL verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Get attribute value of href from the “forgot your password” link
4. Verify attribute value contains
Expected: “/forgot-password.html”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        //4. Verify attribute value contains
        //Expected: “/forgot-password.html”
        //Hint: Locate the “Forgot your password ?” link, and use getAttribute value method
        // to get the link behind the attribute within.

        WebElement forgotPasswordLink = driver.findElement(By.partialLinkText("Forgot "));

        String ActualAttributeValue =  forgotPasswordLink.getAttribute("href");
        String expectedAttributeValue = "/forgot-password.html";

        if(ActualAttributeValue.contains(expectedAttributeValue)){

            System.out.println("Attribute Value Verification PASSED!");
        }else{

            System.out.println("Attribute Value Verification FAILED!");
        }

        //is link displayed or not? returns boolean
        if(forgotPasswordLink.isDisplayed()){

            System.out.println("Forgot Password Link is Displayed, Verification Passed");
        }else{

            System.out.println("Forgot Password Link is NOT  Displayed, Verification Failed");
        }

         driver.close();
    }
}
