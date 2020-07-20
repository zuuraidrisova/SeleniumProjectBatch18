package test.day03_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class searchAmazonCssSelector {
    /*
    Search Amazon
1.Open browser
2. Go to https://amazon.com
3. Enter any search term (use cssSelector to locate search box)
4.Verify title contains the search term
     */

    public static void main(String[] args) throws Exception{

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://amazon.com");

      // driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("wooden spoons"+ Keys.ENTER);
        //this line above also works

        driver.findElement(By.cssSelector("input[tabindex ='19']")).sendKeys("wooden spoon"+Keys.ENTER);

        String actualInTitle = driver.getTitle();
        String expectedInTitle = "wooden spoon";

            Thread.sleep(2000);

         if(actualInTitle.contains(expectedInTitle)){

            System.out.println("Title Verification PASSED!");
        }else{

            System.out.println("Title Verification FAILED!");
        }

        driver.close();

    }
}
