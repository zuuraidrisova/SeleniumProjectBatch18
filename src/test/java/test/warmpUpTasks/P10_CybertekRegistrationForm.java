package test.warmpUpTasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P10_CybertekRegistrationForm {
    /*
    TC#6: Cybertek registration form confirmation
Note: Use JavaFaker when possible.
1. Open browser
2. Go to website: http://practice.cybertekschool.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() throws  InterruptedException{

        Faker faker = new Faker();

      WebElement firstName =  driver.findElement(By.xpath("//input[@name='firstname']"));

      firstName.sendKeys(faker.name().firstName());

      Thread.sleep(1000);

      WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));

      lastName.sendKeys(faker.name().lastName());

      Thread.sleep(1000);

      WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));

      userName.sendKeys("funnyName12");

      Thread.sleep(1000);

      WebElement email = driver.findElement(By.xpath("//input[@name='email']"));

      email.sendKeys(faker.internet().emailAddress());

      Thread.sleep(1000);

      WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

      password.sendKeys(faker.internet().password());

      Thread.sleep(1000);

      WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='tel']"));

      phoneNumber.sendKeys(faker.phoneNumber().cellPhone());

      Thread.sleep(1000);

      WebElement gender = driver.findElement(By.xpath("//input[@value='female']"));

      gender.click();

      Thread.sleep(1000);

      WebElement birthDate = driver.findElement(By.xpath("//input[@name='birthday']"));

      birthDate.sendKeys("11/10/1998");

      Thread.sleep(1000);

      Select department = new Select(driver.findElement(By.xpath("//select[@name='department']")));

      department.selectByIndex(4);

      Thread.sleep(1000);

      Select jobTitle = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));

      jobTitle.selectByVisibleText("SDET");

      Thread.sleep(1000);

      WebElement programmingLanguage = driver.findElement(By.xpath("//input[@value='java']"));

      programmingLanguage.click();

      Thread.sleep(1000);

      WebElement signUP = driver.findElement(By.xpath("//button[@type='submit']"));

      signUP.click();

      WebElement SuccessMessage = driver.findElement(By.xpath("//p"));

      String actualSuccessMessage = SuccessMessage.getText();
      String expectedSuccessMessage = "You've successfully completed registration!";

        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);

        System.out.println("Verification PASSED");


    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
