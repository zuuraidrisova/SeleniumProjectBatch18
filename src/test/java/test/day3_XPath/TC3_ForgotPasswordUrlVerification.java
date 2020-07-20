package test.day3_XPath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPasswordUrlVerification {
    /*
    TC #3: PracticeCybertek/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
Hint: You need to use getText method for this practice.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        //3. Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("zuuraidrisova@gmail.com");
        //4. Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();
        //5. Verify URL contains: Expected: “email_sent”
        String actualUrl = driver.getCurrentUrl();
        String expectedInUrl = "email_sent";

        System.out.println("The current URl is: "+actualUrl);

        if(actualUrl.contains(expectedInUrl)){

            System.out.println("URL verification PASSED!");
        }else{

            System.out.println("URL Verification FAILED!!");
        }


        //6. Verify textBox displayed the content as expected.
        //Expected: “Your e-mail’s been sent!”

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
       // String ActualTextBoxDisplay = driver.findElement(By.name("confirmation_message")).getText();
        String actualMessage = confirmationMessage.getText();
        String expectedMessage = "Your e-mail's been sent!";

        System.out.println("Actual message is: "+actualMessage);

        if(actualMessage.equals(expectedMessage)){

            System.out.println("Confirmation Message Text Verification PASSED!");
        }else{

            System.out.println("Confirmation Message Text Verification FAILED!");
        }


        //if webElement is  displayed or not
        if(confirmationMessage.isDisplayed()){

            System.out.println("Message is displayed, verification PASSED ");
        }else{

            System.out.println("Message is NOT displayed, verification FAILED");
        }
        driver.close();

    }
}
