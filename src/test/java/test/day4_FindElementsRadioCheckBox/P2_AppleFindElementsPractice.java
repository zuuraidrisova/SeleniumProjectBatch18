package test.day4_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_AppleFindElementsPractice {
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

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(" https://www.apple.com");

       WebElement iPhoneLink =  driver.findElement(By.xpath("(//a[@href='/iphone/'])[1]"));

       iPhoneLink.click();

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int countLinksWithoutText = 0;
        int countLinksWithText = 0;

        for(WebElement link:  allLinks){

            String textOfLinks = link.getText();

            System.out.println(textOfLinks);

            if(textOfLinks.isEmpty()){

                countLinksWithoutText++;

            }else{

                countLinksWithText++;
            }
        }
        System.out.println("Number of Links without text: "+countLinksWithoutText);
        System.out.println("Number of Links with Text: "+countLinksWithText);

        System.out.println("Total number of links on the page: "+allLinks.size());


        driver.close();


    }
}
