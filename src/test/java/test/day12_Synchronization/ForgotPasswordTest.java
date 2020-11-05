package test.day12_Synchronization;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VytrackForgotPasswordPage;
import utilities.Driver;
import utilities.configurationReader;

public class ForgotPasswordTest {
    /*
    TC#35 : Vytrack forgot password page verifications à TITLE and URL
1. Go to https://qa2.vytrack.com
2. Click to “Forgot your password?” link
3. Verify title changed to expected
Expected: “Forgot Password”
4. Verify url is as expected:
Expected: “https://qa2.vytrack.com/user/reset-request”
Note: Follow Page Object Model design pattern
     */

    @Test
    public void tc35_title_url_verification(){

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.forgotPasswordLink.click();

        //verify title as expected
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertEquals(actualTitle, expectedTitle);

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/user/reset-request";

        Assert.assertEquals(actualURL, expectedURL);

    }
    /*
    TC#36 : Vytrack forgot password page verification à ERROR MESSAGE
1. Go to https://qa3.vytrack.com/user/reset-request
2. Enter random username
3. Click to request button
4. Verify error message is displayed
5. Verify error message text is as expected.
Expected: There is no active user with username or email address “given text”.
Note: Follow Page Object Model design pattern
     */

    @Test
    public void tc36_errorMessage_verification(){

        Driver.getDriver().get(configurationReader.getProperty("forgotPasswordURL"));

        VytrackForgotPasswordPage forgotPasswordPage = new VytrackForgotPasswordPage();

        //sending random username to input box
        String randomUsername = "something123";
        forgotPasswordPage.UsernameInput.sendKeys(randomUsername);

        //clicking to request button
        forgotPasswordPage.requestButton.click();

        //verifying error message is displayed
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        //Verify error message text is as expected
        String expectedMessage = "There is no active user with username or email address \"something123\".";
        String actualMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }








}
