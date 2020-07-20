package test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    public static void main(String[] args) {

        // 1 ==> set up the web driver
        // ==> creates a connection between driver and selenium

        WebDriverManager.chromedriver().setup();

        // 2 ==> create the instance of the chrome driver
        // ==> to be able to do action on ChromeDriver

        WebDriver driver = new ChromeDriver();
        // -->  this is the line opening the browser session
        //--> each session is brand new session, and no cache or history is stored
        // cache is browser history

        /*
                WebDriver driver = new ChromeDriver();
                                  new OperaDriver();
                                  new AnyAvailableBrowserDriver();
         */


        // 3 ==> if driver is working

      driver.get("https://www.google.com");

      // get("url") ==> it is a method  which gets us the URL passed into it
        // gets the given url in an open browser




    }
}
