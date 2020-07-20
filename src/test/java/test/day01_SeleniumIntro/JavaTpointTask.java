package test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTpointTask {
    /*
    Launch Chrome browser.
Maximize the browser.
Open URL: www.javatpoint.com
Scroll down through the web page
Click on "Core Java" link from the Java Technology section.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.javatpoint.com");

        driver.findElement(By.className("homecontent")).click();
    }
}
