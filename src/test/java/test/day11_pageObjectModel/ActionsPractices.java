package test.day11_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsPractices {


    @Test
    public void scrolling_with_actions() throws InterruptedException{

        //get our page
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //creating an object of Actions class to be able to use its actions
        Actions actions = new Actions(Driver.getDriver());

        //locating web element until which we want to scroll
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement inputs = Driver.getDriver().findElement(By.linkText("Inputs"));

        Thread.sleep(2000);
        //using actions instance we use  moveToElement() method
        actions.moveToElement(cybertekSchoolLink).perform();

        Thread.sleep(2000);
        actions.moveToElement(inputs).click().perform();


    }


}
