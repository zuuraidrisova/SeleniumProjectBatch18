package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    // we create and add repeated actions/methods inside this package
    // good for repeated actions, write once and use as needed, easy to maintain

    public static WebDriver getDriver(String browserType){


        if(browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver();

        }else if(browserType.equalsIgnoreCase("opera")){

            WebDriverManager.operadriver().setup();
            return new OperaDriver();

        }else{

            System.out.println("Given browser Type does not exist.Driver = null!");
            return null;
        }

    }

}
