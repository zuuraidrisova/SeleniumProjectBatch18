package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VytrackForgotPasswordPage {

    public VytrackForgotPasswordPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement UsernameInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;



}
