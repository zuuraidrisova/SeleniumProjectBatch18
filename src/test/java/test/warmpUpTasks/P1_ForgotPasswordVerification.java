package test.warmpUpTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_ForgotPasswordVerification {
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

        //creates a connection between browser and selenium
        WebDriverManager.chromedriver().setup();

        //creates an instance of chrome browser
        WebDriver driver = new ChromeDriver();

        //opens a given url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //makes full screen
        driver.manage().window().maximize();

        //locates an element by name and writes given email address
        driver.findElement(By.name("email")).sendKeys("zuuraidrisova@gmail.com");

        //locates element by id and clicks it
        driver.findElement(By.id("form_submit")).click();

        //verifies if actual url matches expected url
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        if(actualURL.contains(expectedURL)){

            System.out.println("URL Verification PASSED!");

        }else{

            System.out.println("URL Verification FAILED!");
        }

        //verifies if actual msgs equals expected
        String actualTextBoxDisplay = driver.findElement(By.name("confirmation_message")).getText();
        String expectedTextBoxDisplay = "Your e-mail's been sent!";

        System.out.println(actualTextBoxDisplay);

        if(actualTextBoxDisplay.equals(expectedTextBoxDisplay)){

            System.out.println("Text Box Display Verification PASSED!");

        }else{

            System.out.println("Text Box Display Verification FAILED!");
        }


       driver.close();

    }
}
