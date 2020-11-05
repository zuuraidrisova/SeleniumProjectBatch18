package test.day11_pageObjectModel;

public class PageObjectModel {
    /*
    What is PageObjectModel?

    ==> PageObjectModel is creating Java classes  for the each page of the web application
    ==> we will store web elements and methods related to that page into its java class

       two things to remember when creating a new page object model design:
            1. always create a public Constructor and pass below line:
                PageFactory.initElements(Driver.getDriver(), this);
                    it creates connection in between our driver and the object of current class
                PageFactory comes from Selenium library

            2. @FindBy annotation to locate web elements
                @FindBy annotation also comes from Selenium library.
                we can use any locators of Selenium to locate web elements
                           ex: @FindBy(id = "prependedInput")
                                public WebElement usernameInput;


          What are the advantages of Page Object Model?

          -> re-usability : we are creating one place for each web element and keep re-using
                            same object
          -> easy to maintain : since we are creating and locating each web element only once
                            in its own related class, when we have issue with that web element
                            we only go fix it in one place
          -> easy to manage : we are managing

            //Command+z ==> to go back if deleted


     */
}
