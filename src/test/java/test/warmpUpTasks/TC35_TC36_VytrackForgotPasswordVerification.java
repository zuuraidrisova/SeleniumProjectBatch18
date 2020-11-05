package test.warmpUpTasks;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VytrackForgotPasswordPage;
import utilities.Driver;
import utilities.configurationReader;

public class TC35_TC36_VytrackForgotPasswordVerification {

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
    public void vytrackForgotPassword_test(){

        Driver.getDriver().get(configurationReader.getProperty("vyTrack_url"));

        LoginPage loginPage = new LoginPage();

        loginPage.forgotPasswordLink.click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("Verification passed!");

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/user/reset-request";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Verification passed!");

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
    public void forgotPasswordPage_errorMsg_test(){

        Driver.getDriver().get(configurationReader.getProperty("forgotPasswordURL"));

        VytrackForgotPasswordPage forgotPassword = new VytrackForgotPasswordPage();


        forgotPassword.UsernameInput.sendKeys("something123");

        forgotPassword.requestButton.click();

        String actualErrorMessage =  forgotPassword.errorMessage.getText();
        String expectedErrorMessage = "There is no active user with username or email address \"something123\".";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        System.out.println("Verification passed!");

    }
}
