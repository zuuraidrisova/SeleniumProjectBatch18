package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.configurationReader;

/*
we will store all login page related web elements and methods into this class
 */
public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //locating username input box
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    //locating password input box
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    //locating login button
    @FindBy(id = "_submit")
    public WebElement loginButton;

    //locating  error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    //locating forgotPassword link
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;


    public void login(String username, String password){

        usernameInput.sendKeys(username);

        passwordInput.sendKeys(password);

        loginButton.click();

    }


}
