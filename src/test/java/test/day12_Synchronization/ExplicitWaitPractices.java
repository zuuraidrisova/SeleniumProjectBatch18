package test.day12_Synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {

    /*
    TC#40 : Dynamically Loaded Page Elements 7
1. Go to http://practice.cybertekschool.com/dynamic_loading/7
2. Wait until title is “Dynamic Title”
3. Assert : Message “Done” is displayed.
4. Assert : Image is displayed.
Note: Follow POM
     */

    @Test
    public void tc40_dynamicTitleTest(){

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Loading7Page loading7Page = new Loading7Page();

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

        Assert.assertTrue(loading7Page.spongeMessage.isDisplayed());

    }

    /*
    TC#41 : Dynamically Loaded Page Elements 1
1. Go to http://practice.cybertekschool.com/dynamic_loading/1
2. Click to start
3. Wait until loading bar disappears
4. Assert username inputbox is displayed
5. Enter username: tomsmith
6. Enter password: incorrectpassword
7. Click to Submit button
8. Assert “Your username is invalid!” text is displayed.
Note: Follow POM
     */
    @Test
    public void tc41_dynamicForm_test(){

        String url = "http://practice.cybertekschool.com/dynamic_loading/1";
        Driver.getDriver().get(url);

        Loading1Page loading1Page = new Loading1Page();

        loading1Page.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));

        Assert.assertTrue(loading1Page.username.isDisplayed());

        Assert.assertTrue(loading1Page.password.isDisplayed());

        loading1Page.username.sendKeys("tomsmith");

        loading1Page.password.sendKeys("asjkgad");

        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());


    }




}
