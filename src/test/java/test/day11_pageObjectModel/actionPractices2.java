package test.day11_pageObjectModel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class actionPractices2 {

    /*
    TC #16: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
     */
    Actions actions;

    @Test
    public void double_click_test() throws  InterruptedException{

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text “Double-click me to change my text color.”
        WebElement doubleClickText = Driver.getDriver().findElement(By.id("demo"));

        actions = new Actions(Driver.getDriver());

        Thread.sleep(2000);
        actions.doubleClick(doubleClickText).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.

        String actual = doubleClickText.getAttribute("style");
        String expected = "red";

        System.out.println(actual);

        Assert.assertTrue(actual.contains(expected));

        System.out.println("Verification Passed!");
    }

  /*
TC #17: Hover Test
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
         */
    @Test
    public void dragAndDrop_test(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();
        String expectedWhileHover = "Now drop...";
        String actualWhileHover = bigCircle.getText();

        Assert.assertEquals(actualWhileHover, expectedWhileHover);

        System.out.println("Verification Passed!");

        actions.release().perform();

        String actual = bigCircle.getText();
        String expected = "You did great!";

        Assert.assertEquals(actual, expected);

        System.out.println("Verification Passed!");

    }

    /*
    TC #18: Context Click – HOMEWORK
1. Go to https://the-internet.herokuapp.com/context_menu
2. Right click to the box.
3. Alert will open.
4. Accept alert
No assertion needed for this practice.
     */

    @Test
    public void right_click_test() throws InterruptedException{

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        actions = new Actions(Driver.getDriver());

        actions.contextClick(box).perform();

        Alert alert = Driver.getDriver().switchTo().alert();

        Thread.sleep(2000);
        alert.accept();

    }
}
