package test.day07_WebTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P2_SmartBearOrderPlacing {
    /*
    TC#2: Smartbear software order placing
1. Open browser
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() throws InterruptedException{
        //3. Enter username: “Tester”

        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));

        userNameInput.sendKeys("Tester");

        //4. Enter password: “test”

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        passwordInput.sendKeys("test");

        //5. Click on Login button

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        loginButton.click();

        //6. Click on Order

        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));

        Thread.sleep(1000);

        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2

        Select familyAlbum = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));

        Thread.sleep(1000);

        familyAlbum.selectByValue("FamilyAlbum");

        Thread.sleep(1000);

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));

       // quantity.clear();//just deletes if there is any existing input

        quantity.sendKeys(Keys.BACK_SPACE);

        quantity.sendKeys("2");

        Thread.sleep(1000);

        //8. Click to “Calculate” button

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));

        calculateButton.click();

        Thread.sleep(1000);

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code

        Faker faker = new Faker();
        WebElement customerName = driver.findElement(By.xpath("//input[@name ='ctl00$MainContent$fmwOrder$txtName']"));

        customerName.sendKeys(faker.name().fullName());

        Thread.sleep(1000);

        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));

        street.sendKeys(faker.address().streetName());

        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));

        city.sendKeys(faker.address().cityName());

        Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));

        state.sendKeys(faker.address().state());

        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));

        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        Thread.sleep(1000);

        //10. Click on “visa” radio button

        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@value='Visa']"));

        visaRadioButton.click();

        Thread.sleep(1000);

        //11. Generate card number using JavaFaker

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));

        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        Thread.sleep(1000);

        WebElement expireDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));

        expireDate.sendKeys("12/23");

        Thread.sleep(1000);

        //12. Click on “Process”

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        //WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();

        Thread.sleep(1000);

        //13. Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        String actualSuccessMessage = successMessage.getText();
        String expectedSuccessMessage = "New order has been successfully added.";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        System.out.println("Verification Passed!");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }



}
