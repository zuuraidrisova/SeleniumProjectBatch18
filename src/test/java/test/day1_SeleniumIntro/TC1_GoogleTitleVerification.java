package test.day1_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_GoogleTitleVerification {

    /*
    TC #1: Google Title Verification
    1. Open Chrome browser
            set up my web driver
    2. Go to https://www.google.com
    3. Verify title: Expected: Google
     */

    public static void main(String[] args) {

        //  1. Open Chrome browser
        //            set up my web driver
        WebDriverManager.chromedriver().setup();

        // create an instance of my chrome driver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();// to make it full screen

        //to go to google page
        driver.navigate().to("https://www.google.com");

        String title = driver.getTitle();

       // 3. Verify title: Expected: Google
        if(title.equals("Google")){

            System.out.println("Google title verification PASSED");

        }else{

            System.out.println("Google title verification FAILED");
        }




    }


}
