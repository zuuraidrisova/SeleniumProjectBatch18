package test.day03_XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class absoluteXPATHPractice {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

       if(homeLink.isDisplayed()){

           System.out.println("Home link is displayed on the page, PASS!");
       }else{

           System.out.println("Home link is NOT displayed on the page,FAIL");
       }

    }
}
