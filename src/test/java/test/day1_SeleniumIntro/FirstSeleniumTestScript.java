package test.day1_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstSeleniumTestScript {

    /*
 Invoke Google Chrome browser.
Open URL: www.google.com
Click on the Google Search text box.
Type the value "javatpoint tutorials"
Click on the Search button.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");

        driver.findElement(By.name("btnK")).click();





    }
}
