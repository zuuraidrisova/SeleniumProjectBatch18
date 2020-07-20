package test.day12_Synchronization;

public class RecapNotes {
    /*
    JULY 7TH, TUESDAY
TODAY'S SCHEDULE
    -RECAP
    -SOLVE TASKS
    -SYNCHRONIZATION
    -JUNIT
FRIDAY
    -DIFFERENT TYPES OF FRAMEWORKS
    -WHAT IS BEHAVIOR DRIVEN DEVELOPMENT FRAMEWORK
    -CUCUMBER
    -CREATE A NEW PROJECT AND IMPLEMENT CUCUMBER
=======================================================
- PAGE OBJECT MODEL DESIGN PATTERN
    - WHAT IS PAGE OBJECT MODEL?
        -> PAGE OBJECT MODEL IS NOT A FRAMEWORK, IT IS A DESIGN PATTERN.
        -> We implement design patterns into our existing frameworks.
        -> Simply put, page object model is creating Java classes for each page of the
        web application we are working on.
        -> We put relevant web elements and actions belonging to these pages.
        LOGIN PAGE
            -> LoginPage.java
                -> username input
                -> password input
                -> login button
                -> forgot password link
                -> remember be
                -> error message when we enter username/password wrong
                -> create and store login method into this class
        HOME PAGE
            -> HomePage.java
        DRIVERS
            -> DriversPage.java
        SALES
            -> SalesPage.java
    - HOW DID YOU/DO YOU IMPLEMENT IT INTO YOUR FRAMEWORK?
    - We implement page object model in 2 steps.
    Step #1:
        -> We create a public constructor of the class.
        -> Then we use PageFactory.initElements();
    -> What does PageFactory.initElements(); this line do?
        -> This method accepts two arguments.
        -> driver instance, and the object reference of the class
        -> AND => IT CREATES CONNECTION BETWEEN THE DRIVER AND THE OBJECT REFENCE OF THE CLASS.
        public class HomePage{
            public HomePage(){
                PageFactory.initElements(Driver.getDriver(), this);
            }
            WEBELEMENT
        }
        CLASS B
        HomePage homePage = new HomePage();
        homePage.webelement.sendKeys();
    -> STEP #2:
        - We use @FindBy annotation to locate web elements
        - We are able to use one of 8 locators of selenium to locate web elements
        syntax:
            @FindBy(id="something")
            public WebElement searchBox;
        homePage.searchBox.sendKeys(); -->
        => handling more than one web element

            @FindBys(xpath = "//somexpath")
            public List<WebElement> listofsomething;
    How do we achieve PAGE OBJECT MODEL DESIGN PATTERN?
        Step1: Create constructor and add PageFactory.initElements method
        Step2: Use @FindBy annotation to locate web elements.
    - ADVANTAGES:
        #1: Re-usability : it reduces the code duplication
        #2: Easy to maintain : if something changes, we go 1 class and fix there
        #3: Easy to read-understand (for ourselves, and the team)
    - DISADVANTAGES:
        -> In the beginning it takes more time to get to the writing the tests phase.
            (advantage coming from the disadvantage)
        -> But the more web elements we create in the beginning, the less work is
        left for us in the future. So later on, we will just keep re-using the methods.

     */
}
