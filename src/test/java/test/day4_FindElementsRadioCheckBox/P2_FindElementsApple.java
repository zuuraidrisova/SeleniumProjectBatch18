package test.day4_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_FindElementsApple {
    /*
    TC #02: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to iPhone
4. Print out the texts of all links
5. Print out how many link is missing text
6. Print out how many link has text
7. Print out how many total link
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();;

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.apple.com");

        driver.findElement(By.xpath("//body//a[@class='ac-gn-link ac-gn-link-iphone']")).click();

        List<WebElement> listOfLinks =  driver.findElements(By.xpath("//body//a"));

        //4. Print out the texts of all links
        for(WebElement eachLink : listOfLinks){

           String textOfEachLink =  eachLink.getText();

            System.out.println(textOfEachLink);
        }
        System.out.println("========================================");
        //5. Print out how many link is missing text
        //6. Print out how many link has text

        int countLinksWithoutText = 0;
        int countLinksWithText = 0;

        for(WebElement eachLink: listOfLinks){

           String textOfEachLink = eachLink.getText();

           if(textOfEachLink.isEmpty()){

               countLinksWithoutText++;

           }else{

               countLinksWithText++;
           }
        }

        System.out.println("number of links without text:  "+countLinksWithoutText);
        System.out.println("number of links with text: "+countLinksWithText);

        System.out.println("Total number of links on the page: "+listOfLinks.size());

        System.out.println("=================================================");

        driver.close();


    }
}
