package test.day11_pageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;
import utilities.configurationReader;

public class PositiveLoginTests {

    /*
TC#32 : Vytrack positive login test à Sales Manager
1. Go to https://qa3.vytrack.com
2. Enter correct username
3. Enter correct password
4. Verify title changed
Expected: “Dashboard”
Note: Follow Page Object Model design pattern
 */

    LoginPage loginPage;

    @Test
    public void positive_login_test() throws InterruptedException{

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        loginPage = new LoginPage();

        String username = configurationReader.getProperty("storeManager_username");
        String password = configurationReader.getProperty("storeManager_password");

        loginPage.login(username, password);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        Thread.sleep(2000);
        System.out.println(actualTitle);

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("Verification passed!");
    }
}
