package test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumNavigations{
    /*

    Selenium Navigations:

        back() : takes us to previous page

        forward() :  takes us to forwarded page

        refresh():  refreshes the page

        to() : takes us to another given url

     */
    public static void main(String[] args) throws Exception {

        // 1 ==> set up the web driver
        // ==> creates a connection between driver and selenium

        WebDriverManager.chromedriver().setup();

        //create an instance of a browser

        WebDriver driver = new ChromeDriver();

        //this whole line of methods maximize the current window
        driver.manage().window().maximize();

        String googleURL = "https://www.google.com";

        //this line launches the browser and goes to the given url
        driver.get(googleURL);

        //Thread.sleep(2000) is being added just to be able to see selenium movements
        //Thread.sleep(2000); -> pauses the program execution for given milliseconds.

        Thread.sleep(2000);//line makes wait between commands

        //navigate().back(); will take user to the previous page

        driver.navigate().back();

        Thread.sleep(2000);//line makes freeze for little between commands

        //navigate().forward(); will take user to the next page

        driver.navigate().forward();

        Thread.sleep(2000);//line makes wait between commands

        //navigate().refresh(); will refresh the page

        driver.navigate().refresh();

        Thread.sleep(2000);//line makes wait between commands

        // navigate().to() will take user to another given URL

        driver.navigate().to("https://www.facebook.com");

        /*
        these both do the same thing, but only difference is :
        driver.get() : will wait the page to be loaded before continuing

        navigate().to() : does not wait the whole page to be downloaded
         */

        //driver.getTitle();  returns us web page title asa string

        String title = driver.getTitle();

        System.out.println("Driver title is: "+title);

        // driver.getCurrentUrl(); returns the current url on browser as a string
        // no parameters for the method,
        //good for confirming if we are on the same page as intended

        String currentUrl = driver.getCurrentUrl();

        System.out.println("the current browser's url is: "+currentUrl);

        // driver.getPageSource(); method which returns whole page source of the current browser as a string

        String pageSource =  driver.getPageSource();

       // System.out.println(pageSource); it works just dont want to have whole source


        // driver.close() :  closes an open browser
        //driver.quit() : closes all tabs and ends the session
        driver.close();

        // pkill -9 Google Chrome : closes all the chrome browsers at once, used thru terminal





    }
}
