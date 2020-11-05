package test.day02_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerification {
    /*
    TC #1: EtsyTitle Verification
    1.Open Chrome browser
    2.Go to https://www.etsy.com
    3.Search for “wooden spoon”
    4.Verify title: Expected: “Wooden spoon | Etsy"
     */
    public static void main(String[] args) {

        //creates connection between selenium code and browser
        WebDriverManager.chromedriver().setup();

        //1.Open Chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2.Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3.Search for “wooden spoon” by id

       driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon");
       //we can also use Keys.ENTER ==> to submit search

        // locating and clicking to the search button using class attribute value
        //locating the search button
       driver.findElement(By.className("wt-input-btn-group__btn")).click();

        //4.Verify title: Expected: “Wooden spoon | Etsy"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";

        if(actualTitle.equalsIgnoreCase(expectedTitle)){

            System.out.println("Etsy Title Verification PASSED!");

        }else{

            System.out.println("Etsy Title Verification FAILED!");
        }



    }
}
