package test.day02_FindElement;

public class notesLocators {
    /*

  findElement()==> method which finds and returns a single web element
        return type is Web Element
        whenever it cannot find a webElement by given locator , it will throw
        NoSuchElement Exception

  Locators:
         There are 8 different types of locators in Selenium

         1. name ==> this locator will be looking whole html code and
                     return the WebElement with matching attribute value
                     return the first element it finds

         syntax:  driver.findElement(By.name("name attribute value));

        2.linkText ==> it allows user to locate links by their text
                Only works only links,
                i know it is link by <a> webelement
                <a href = "https://www.google.com"> TEXT HERE </a>

                syntax;  driver.findElements(By.linkText("TEXT HERE));

         3. partialLinkText: ==>  it allows user to locate links by their half text
                Checks if the given text is contained in the link
             syntax;  driver.findElements(By.linkText("TEXT)) OR ("HERE");

             linkText ==>  equals == checks for the exact match
             partialLinkText ==> contains == checks for partial match of the text


         4. id: ==> will locate by matching id attribute's value
                    id values are unique for that specific webELEMENT
                    if you have id and it is not dynamic(meaning it is not changing
                    when u refresh the page), you should always use id

            syntax:  driver.findElement(By.id("id attribute's value"));

        5. class name: ==> locates by their class name
                    className is not unique
                    it returns the first one it finds

            syntax:  driver.findElement(By.className("class attribute's value));

        6. tagName: ==> locates using tag name itself
            good for locating all of the same type of webElements
            ex:
             driver.findElement(By.tagName("a"));
             driver.findElement(By.tagName("div"));
             driver.findElement(By.tagName("input"));
             driver.findElement(By.tagName("h1"));


    getText() --> method which gets the text of given webElement, no parameters
                    returns a text as a string

      gets text in between opening and closing tags <div>text here</div>

      <a href="https://www.google.com"> CLICK HERE TO GO GOOGLE</a>


    getAttribute("attribute's value") -->  gets an attribute value,
            accepts string as argument and return type is a string

            how to use:
                1.we need to locate webelement
                2.we decide which attribute value we get
                3.we pass attribute name inside method
                4.this method will be returning the value of attribute
     */
}
