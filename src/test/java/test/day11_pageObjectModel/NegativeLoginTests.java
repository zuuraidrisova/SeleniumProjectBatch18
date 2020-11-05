package test.day11_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;
import utilities.configurationReader;

public class NegativeLoginTests {

    //this is before introducing Page Object Model practice
    @Ignore
    @Test
    public void negativeLogin_test(){

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        usernameInput.sendKeys(configurationReader.getProperty("storeManager_username"));
        passwordInput.sendKeys("askjgdei64");

        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is not displayed!");

        System.out.println("Verification passed!");

        //Invalid user name or password.

        String expectedMessage = "Invalid user name or password.";
        String actualMessage = errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Verification passed!");

    }
    /*
    TC#30 : Vytrack negative login test à Wrong Password Test
1. Go to https://qa3.vytrack.com
2. Enter correct username
3. Enter incorrect password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Follow Page Object Model design pattern
     */

    LoginPage loginPage;

    @Test
    public void negative_login_test_with_page_object(){

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

       loginPage = new LoginPage();

        //sending username
        String username = configurationReader.getProperty("storeManager_username");
        loginPage.usernameInput.sendKeys(username);

        //sending incorrect password
        String password = "something123";
        loginPage.passwordInput.sendKeys(password);

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String expectedMessage = "Invalid user name or password.";
        String actualMessage = loginPage.errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Verification passed!");

    }
    /*
    TC#31 : Vytrack negative login test à Wrong Username Test
1. Go to https://qa3.vytrack.com
2. Enter incorrect username
3. Enter correct password
4. Verify error message text is as expected
Expected: “Invalid user name or password.”
Note: Follow Page Object Model design pattern
     */
    @Test
    public void wrong_username_test(){

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        loginPage.login("something123", configurationReader.getProperty("storeManager_password") );

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String expectedMessage = "Invalid user name or password.";
        String actualMessage = loginPage.errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

        System.out.println("Verification passed!");
    }

}
