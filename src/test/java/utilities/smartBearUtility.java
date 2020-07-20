package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class smartBearUtility {

       /*
    Mini-Task:
• Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
     */
    public static void login(WebDriver driver) {


        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }
    /*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
     */

    public static void verifyOrder(WebDriver driver, String name){

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));

        String eachNames = "";

        for(WebElement each : listOfNames){


            if (each.getText().equals(name)){

                eachNames += each.getText();
            }

        }
        Assert.assertTrue(eachNames.equals(name));
    }

    /*
    Practice #5: Method: printNamesAndCities
• Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city
     */

    public static void printNamesAndCities(WebDriver driver){

        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        List<WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));


        String output = "";

        for(int  i = 0; i < listOfNames.size(); i++){

            output = "Name"+(i+1)+": "+listOfNames.get(i).getText()+" , "+"City"+(i+1)+": "+listOfCities.get(i).getText();;

            System.out.println(output);
        }

    }





}