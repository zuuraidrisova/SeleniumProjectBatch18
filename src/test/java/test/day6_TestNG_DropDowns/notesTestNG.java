package test.day6_TestNG_DropDowns;

public class notesTestNG {
    /*

    TestNg ==> stands for TEST NEXT GENERATION
            unit testing tool that allows us to create flow using annotations

           1.  we create java methods
           2.  we create testNG annotations to create running flow


                   it helps us create test structure
                    decides which method runs before test
                    which method runs after test and so on

       Annotations: are a way of controlling the flow of test
we dont need main method in java to run our methods from now on, because of annotations

      1.  @Test: ==> makes the annotated method a TestNg test

                    which allows us run those methods(tests) without main method
                    all of tests are independent from each other, unless we create dependency

            ex:     @Test
                    public void test1(){

                    }

      2. @BeforeMethod: ==> makes the annotated method run before each @Test method
                            usually used setting up conditions, getting browsers and pages

           ex:  @BeforeTest
                public void setUp(){

                        WebDriver driver = WebDriverFactory.getDriver("chrome");

                        driver.get("url");

                        maximize

                        implicit wait
                }

        3. @AfterMethod: ==> makes the annotated method run after each @Test method
                            usually used to finalize or close the browser


                ex: @AfterMethod
                     public void tearDown(){

                        driver.close();
                        driver.quit();
                     }

        4. @BeforeClass: ==> makes annotated method runs only one time before all tests in class
                            runs even before the BeforeMethod
                            used for setting up the environment, opening browsers

                if you want to open just one browser and run all of your tests in that
                browser, you can put WebDriver driver = new ChromeDriver(); into beforeClass

                if you want to open a browser for each test, you need to put that line into
                BeforeMethod

                 ex: @BeforeClass
                      public void

        5. @AfterClass: ==> makes annotated method run once after the tests in the class


        ASSERTIONS come from testNG:

        ==> Assertions allow us to do our verifications between actual and expected results
        ==> if assertions pass, there will be no output in console
        ==> if assertions fail, it will tell us what failed and why in console
        ==> assert class is the class that provides us with all of the assertions

        Assert.assertEquals(actual, expected); ==> all methods in Assert class can be called
                                 thru the class name, since they are all static methods
          => if we use static import, we dont have to use the class name to call the methods

       1. assertEquals(): => expects two arguments to be passed: actual and expected
                            and compares these two values and if they match, it will pass.

              Assert.assertEquals(1,1);
              Assert.assertEquals("title", "title");
              Assert.assertEquals("title", driver.getTitle());

          You can pass additional argument into assertion methods just to provide additional
          information about what failed, it is optional.

      2. assertTrue(): => expects you to pass boolean value, if boolean value is true,
                            it will pass,  if not it will fail.
                            or you have to pass a method that returns a boolean value.

        Methods returning boolean values: isSelected(), isDisplayed(), isEmpty()
                                            contains(), equals(), startsWith();

        assertFalse():=> expects you to pass a boolean value, if boolean value is false,
                        it will pass, if it is not false it will fail.

     if your assertion fails, it will stop executing the current test in the same line
      where it failed, and move to the next test and run it, for this reason it is not
      suggested to do multiple assertions in one test, unless u have to.


    How to ignore a test?

        first way:  add @Ignore annotation on top of test
        second way: comment out @Test annotation

   In what order the tests are running if we have multiple tests?
         ==> by default, tests run in alphabetical order
         ==> @Test (priority = 2) we can specify in what priority we wanna run our tests
                we can even pass negative numbers in priority


   How do we handle dropdowns in Selenium?

   there are 2 types of Dropdowns:

    1.  Select dropdowns: created by using <select> tag in HTML
        <select>
        <option value ="1">Orange </option>
        <option value ="2">Apple </option>
        <option value ="3">Kiwi </option>
        </select>

    2. Html dropdowns: created NOT  using <select>
            these dropdowns are handled are just like any other web element

  What can be tested about a  dropdown?
   - what is selected by default?
   - what options are available in dropdown?
   - when you select an option, is it selected?

    How do we handle SELECT dropdowns using Selenium?

        1. we need to locate the dropdown using findElement();
        2. we need to create an object of select class
                (select class comes from selenium libraries)
        3. we need to pass the located WEB element into Select object

        syntax1:  WebElement dropdown = driver.findElement(By.locator);

                Select select = new Select(dropdown);

                select. ==> do some actions on dropdown

       syntax 2:
                Select select = new Select(driver.findElement(By.locator));


    How do we actually select an option from dropdowns? ==> 3 ways

        1. byVisibleText
            this method accepts a string argument and selects  the option with given text
            syntax: select.selectByVisibleText("Orange"); ==> will select orange

         ex:
         <select>
        <option value ="1">Orange </option>
        <option value ="2">Apple </option>
        <option value ="3">Kiwi </option>
        </select>


        2. byIndex
            this method accepts an int argument as the index number of option
            index number starts from 0
            syntax: select.byIndex(2);==> will select kiwi

        ex:
        <select>
        <option value ="1">Orange </option> ==>index 0
        <option value ="2">Apple </option>  ==>index 1
        <option value ="3">Kiwi </option>   ==>index 2
        </select>

        3. bySelectByValue
            this method uses the value of attribute value to select options
            syntax: select.byValue("2") ==> will select apple option
         ex:
         <select>
        <option value ="1">Orange </option>
        <option value ="2">Apple </option>
        <option value ="3">Kiwi </option>
        </select>


======> getFirstSelectedOption() ==> this method returns the selected option
           ==> useful for getting default value of option in dropdown
           ==>  you can also select smth, and get the va;ue using the method

======> getOptions() ==> this method returns all options in given select dropdown
            ==> return type is  List of WebElements

======> getAllSelectedOptions() ==> returns all selected options as web element
        useful when you have a dropdown that allows you to select multiple options

======> deSelectAll() ==> this will deselect all options that are selected





     */

}
