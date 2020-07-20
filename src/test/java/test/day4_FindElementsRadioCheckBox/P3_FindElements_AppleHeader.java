package test.day4_FindElementsRadioCheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;

public class P3_FindElements_AppleHeader {
    /*
    TC #03: FINDELEMENTS_APPLE
1. Open Chrome browser
2. Go to https://www.apple.com
3. Click to all of the headers one by one
a. Mac, iPad, iPhone, Watch, TV, Music, Support
4. Print out how many links on each page with the titles of the pages
5. Loop through all
6. Print out how many link is missing text TOTAL
7. Print out how many link has text TOTAL
8. Print out how many total link TOTAL
     */

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        //2. Go to https://www.apple.com


        //connecting browser with driver==> open chrome browser
        WebDriver driver =  WebDriverFactory.getDriver("chrome");

        //making screen to full extent
        driver.manage().window().maximize();

        //going to the given url
        driver.get("https://www.apple.com");

        //creating counters: emptyLinks and links with text
        int emptyLinkCounter = 0;
        int linksWithText = 0;

        Thread.sleep(500);

        //3. Click to all of the headers one by one
        //a. Mac, iPad, iPhone, Watch, TV, Music, Support


        //creating the list of all webElements to store all the links in the header
       List<WebElement> appleHeaderList = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

       //to loop where we specify to start from and where to end in appleHeader list
       for(int  i = 1; i < 8; i ++) {

           appleHeaderList.get(i).click();//clicks every single webElements
           Thread.sleep(500);
           List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

           //4. Print out how many links on each page with the titles of the pages

           System.out.println("Number of links on page: "+driver.getTitle()+" "+listOfLinks.size());
           //text of links

           //5. Loop through all
           //6. Print out how many link is missing text TOTAL
           //7. Print out how many link has text TOTAL
           //8. Print out how many total link TOTAL

           for(WebElement link : listOfLinks){

               String textOfLink = link.getText();

               if(! textOfLink.isEmpty()){

                   linksWithText++;//to count how many link has text TOTAL

               }else{

                   emptyLinkCounter++;//to count how many link is missing text TOTAL
               }
           }

           driver.navigate().back();

           appleHeaderList = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

       }

        System.out.println("Number of empty links:  "+emptyLinkCounter);
        System.out.println("Number of links with text: "+linksWithText);






    }

}
