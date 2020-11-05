package test.day03_XPath;

public class notesXPATH {
    /*
    Maven is built automation tool
        helps us automate steps we repeat every time we create projects
        =>project
        =>folder structure
        =>add libraries
        comes with pre-created folder structure

         projectName

                src
                    main
                    test

                pom.xml ==> project object model==>it helps us add dependencies
                        ==> it helps us control versions of tools we add into our project

            .findElement(locator) ==> method which finds and returns specific web element
                                      it accepts String as prmtr as locator and returns
                                      web element, if it did not find it will throw
                                      noSuch Element Exception
                                      return type : webElement

            .click() ==> clicks to the given web element
                         no parameters
                         u have to locate the button to click and it will imitate the mouse click

            .sendKeys("text to be sent here") ==> send the given string to located web element

            Keys.ENTER ==>  allows us to imitate pressing Enter key from keyboard

            .getText() ==> gets the text of given web element
                            does not accept any parameters
                            return type = String

                            <div class ="uh7" id="fa83" name ="uk94">
                                <a href ="www.tesla.com"> TESLA WEB PAGE! </a>
                            </div>

                            driver.findElement()By.id("fa83").getText()

                            if the text you want to get in BETWEEN opening and closing tag , you
                            need to use getText() method


            getAttribute("attribute") ==> gets the text value from any attribute value
                                if the text value you want to get  is inside opening tag,
                                meaning it is some kind of attribute value
                                return type is String

                                <div class ="uh7" id="fa83" name ="uk94">
                                <a href ="www.tesla.com"> TESLA WEB PAGE! </a>
                                </div>

                                driver.findElement()By.id("fa83").getAttribute("name")

               8 Locators:

               1.By.id  ==> looks for id attribute's value
               2.By.name ==> looks for name attribute's value
               3.By.className ==> looks for className attribute's value
               4.By.tagName ==> looks for tagName attribute's value
               5.By.linkText ==> looks for the text of the link <a>
               6.By.partialLinkText ==> looks for partialLinkText  attribute's value

                linkText and partialLinkText can only be used on <A> tags
                linkText : looks for the exact text of web element
                partialLinkText : looks for the partial text of web element

            what is an email format?
                      username@domain.com

    String sentence = "this is a sentence";
    sout -> sentence.split();
    String splitSentence = sentence.split();
    WebElement element = driver.findElement(LOCATOR);

            WebElement : driver.findElement returns us a WebElement type
                     - We can store this type into "WebElement" coming from Selenium
                     - Every time we use this "WebElement" there will be a "freshness" check

        .isDisplayed();
              -> Check if a web element is displayed on the page or not
              -> Return type is boolean
              -> If web element is displayed, it returns true
              -> If web element is not displayed, it returns false
              -> It does not accept any arguments

        Last 2 Locators in Selenium?

        When we use last 2 locators?

            => when you do not have any other option, u need to go for cssSelector or xPath
            => they both have their own syntax, by creating your own custom locators
            => custom locators allow you to locate everything

        7. cssSelector

            => it has its own syntax, there are some syntaxes for commonly used selectors

            1. tagName[tagName ='value']
            2. tagName.value ==> . dot in css selector means class
                    looks for tagNames that has given class attribute value
            3. tagName#value ==> # hash-tag in css selector looks for id  attribute value

            <div class ="uh7" id="fa83" name ="uk94">
                                <a href ="www.tesla.com"> TESLA WEB PAGE! </a>
              </div>

            - div[class ='uh7'] ==> in cssSelector

           ex for 1. driver.findElement(By.cssSelector("div[class ='uh7']"));
           ex for 2. driver.findElement(By.cssSelector("div.uh7"));
           ex for 3. driver.findElement(By.cssSelector("div#fa83"));

            to go to child: you need to use > sign and pass the child tagName



        8. xpath

        => when you are not able to use other 6 locators, use xpath
        there are 2 types of xpath locators:

        1.absolute xpath
            -> starts with single slash -> /
            -> starts from the very beginning of html code <html>
      => not reliable, because breaks easily, if developer makes a minimal structural change
    in HTML code, locator will not work, we need to try to avoid using it

             <html> ==> this is where absolute path starts
                <head></head>
                <body>
                    <div>
                        <p>this is my paragraph</p>
                    </div>
                </body>
             </html>
        syntax:
            driver.findElement(By.xpath("/absolute xpath here"));

               ex: if i want to locate using absolute path

                       /html/body/div/p
                       //html/body/div[1]/div[1]/div/div
     you use the [] when u have more than 1 sibling and u r specifying which sibling u need

        2.relative xpath

        ==> starts with double slash -> //
        ==> when you say // it allows u to start any where in html code
        ==> more reliable , more specific

        syntax:

       1. driver.findElement(By.xpath("//relative xpath here"));

            1.//tagName[@attribute ='value'] ==> looks for tagName and attribute value
                    //*[@attribute='value'] ==> * means look for all of the web elements

            2.//tagName[contains(@attribute,'value')]  --> locates all web elements with given value

            3.//tagName[.='text'] ==> exact text match in web element


            to go from parent to child using xpath : use /

            to go from child to parent using xpath : use /..
            this will take  you to the direct parent of the current web element

     */





}
