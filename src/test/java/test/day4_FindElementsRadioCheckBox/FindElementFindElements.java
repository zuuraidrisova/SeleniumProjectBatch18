package test.day4_FindElementsRadioCheckBox;

public class FindElementFindElements {
    /*

    findElement() ==> method is used to locate a single web element
                        returns a single web element
                        return type => web element
                        if it cannot find any webElement, throws NoSuchElementException

   findElements() ==> method is used to find more than one webElement
                   locates and returns all the matching web element as a list
                   return type => list<WebElement>
                   if it cannot a webElement, it does not throw exception, returns empty list

        Thread.sleep(2000) ==>comes from java, not Selenium
                              stops running of the code for the given milliseconds
                              it is not recommended to use

      implicit wait: ==> driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
                            type of Selenium wait, comes from Selenium not java
                            implicit wait will check DOMain(html) and wait until given seconds
                             if there are any web elements not available
                             implicit wait will continue until when the page is loaded
                             it does not have to wait until given seconds, if the page loaded


        RadioButtons: type = "radio"
                radio buttons allow users to pick one of options
                when we choose one of the options ==> radio button

        Checkbox: type ='checkbox"
                checkboxes allow users to select one or  several options
                when we can choose couple of option ==>checkbox

    how do we handle checkboxes and radio buttons in Selenium?

        isSelected() ==> if checkbox is selected it will return true, else false
        isEnabled() ==> if checkbox is enabled on the page, it will return true


    Absolute xpath :
                -> starts with : /
                -> starts from the very beginning of  <html>
                -> u can only go from parent to child

   Relative xpath:
               -> starts with: //
               -> looks thru everything in html code
               ->returns all matching results
               -> u can start from anywhere in the html code




     */

}
