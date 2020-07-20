package test.day02_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4_GoogleTitleVerification {
    /*
    TC#4:	Google	search
    1-Open	a	chrome	browser
    2-Go	to:	https://google.com
    3-Write	“apple”	in	search	box
    4-Click	google	search	button5-Verify	title:
    Expected:	Title	should	start	with	“apple”
     */

    public static void main(String[] args) {

        //connecting selenium and browser
        WebDriverManager.chromedriver().setup();

        //creating instance of chromeDriver
        WebDriver driver = new ChromeDriver();

        //to make it fullscreen
        driver.manage().window().maximize();

        //to go to given url
       // driver.navigate().to("https://google.com");==>this will also work
        driver.get("https://google.com");

        //write "apple and search by pressing Enter
       // driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        driver.findElement(By.name("q")).sendKeys("apple"+Keys.ENTER);

        //click google search button
        //driver.findElement(By.name("btnK")).click();

        //verify title
        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        if(actualTitle.startsWith(expectedTitle)){

            System.out.println("Google Title Verification PASSED!");

        }else{

            System.out.println("Google Title Verification FAILED");
        }










    }
}
