package test.day1_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_CybertekVerification {
    /*
    TC #2: Cybertek verifications
    1. Open Chrome browser
    2. Go to https://practice.cybertekschool.com
    3. Verify URL contains
         Expected: cybertekschool
    4. Verify title:
        Expected: Practice
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("http://practice.cybertekschool.com");

        String currentURL = driver.getCurrentUrl();
        String expected = "cybertekschool";

        if(currentURL.contains(expected)){

            System.out.println(true);

        }else{

            System.out.println(false);
        }


        String title = driver.getTitle();
        String expectedTitle = "Practice";

        if(title.equals(expectedTitle)){

            System.out.println(true);
        }else{

            System.out.println(false);
        }

    }
}
