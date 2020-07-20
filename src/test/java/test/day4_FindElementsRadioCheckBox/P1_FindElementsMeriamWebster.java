package test.day4_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_FindElementsMeriamWebster {
    /*
    TC #0: FINDELEMENTS
1. Open Chrome browser
2. Go to https://www.merriam-webster.com/
3. Print out the texts of all links
4. Print out how many link is missing text
5. Print out how many link has text
6. Print out how many total link
     */
    public static void main(String[] args) {

        //opens chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //makes window full screen
        driver.manage().window().maximize();

       // implicit wait waits until page is loaded, upto 15 seconds
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //goes to given url
        driver.get("https://www.merriam-webster.com/");


        List<WebElement> listOfLinks =  driver.findElements(By.xpath("//body//a"));
        //we are creating a list of web elements and storing values returned

        int countMissingText = 0;
        int countLinkWithText = 0;

        for(WebElement eachLink : listOfLinks){

           String textOfEachLink =  eachLink.getText();

            if(textOfEachLink.isEmpty()){
                //4. Print out how many link is missing text
                countMissingText++;
           }else{
                //5. Print out how many link has text
                countLinkWithText++;
            }

        }
        System.out.println("Links that have no text: "+countMissingText);
        System.out.println("Links with text: "+countLinkWithText);

        System.out.println("==========================================");
        //6. Print out how many total link
        System.out.println("Total number of links: "+listOfLinks.size());

        System.out.println("==========================================");

            //3. Print out the texts of all links
        for(int i = 0; i < listOfLinks.size(); i++){

           String textOfEachLink =  listOfLinks.get(i).getText();

            System.out.println(textOfEachLink);
        }


        driver.close();



    }


}
