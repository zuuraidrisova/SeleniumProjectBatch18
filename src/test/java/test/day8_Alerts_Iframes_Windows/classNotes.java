package test.day8_Alerts_Iframes_Windows;

public class classNotes {
    /*
    DROPDOWNS
HOW MANY TYPES OF DROPDOWNS ARE THERE?
2 types of dropdowns:
    1- HTML
    2- Select
How do we handle HTML dropdown?
    -> We handle HTML dropdown just as another web element.
    -> We locate using findElement(LOCATOR)
    -> We click.
How do we handle Select dropdown?
    -> Select dropdowns are different from other dropdowns.
    -> They are created using <select> tag.
    -> You have to create an object of Select class.
    -> After creating the object, we need to locate and pass the <select> web element into
    the constructor of the select object.
    -> Then using the object, we can do action on select dropdowns.
    -> Select class is coming from Selenium.
How many types of selecting options regarding Select dropdowns?
    -> 3 options
        - selectByVisibleText
        - selectByValue
        - selectByIndex
.getOptions : gets all the options in select dropdown.
    -> Return type is List of web elements.
JAVAFAKER:
    -> Javafaker is not coming from java, selenium or test ng.
    -> It is another library by itself. Its javafaker library.
    -> Basically, it allows us to create/generate random data we can use for testing purposes.
    Syntax: Faker faker = new Faker();
How to handle dynamic web elements?
    1- First I would try to locate one of the static parents or childs if there are any.
    And then I would locate the desired web element from there.
    2- Xpath has its own methods which helps us to locate dynamic web elements by their
     attribute values.
        -> starts-with
        -> ends-with
        -> contains
How do we handle web tables?
    - By creating custom locators to get whatever I need to get from the table.
    -> If I need to get the whole row, I create a locator that returns me the whole row.
    -> If I need to get 1 single cell, I need to create a locator that returns me 1 single cell
     */
}
