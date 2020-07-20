package test.day07_WebTables;

public class RecapNotes {
    /*

    findElement==> return type is WebElement
                   throws NoSuchElementException
    findElements ==> return type is list of WebElements
                    throw empty list

     How many dropdowns do we have? ==> 2

        1. HTML Dropdowns
            -> just like another html dropdown
            -> these dropdowns are created usually divs and links
            -> when you inspect, if you see it is not created using <select> tag,
                it means it is not  SELECT dropdown
            -> therefore we cannot use SELECT class methods on it

            how do we handle HTML dropdowns?
                just like any other html tag, we just locate using any locator and click.

        2. Select Dropdowns
            -> created using  <select> tag
            ->if dropdown is created using  <select> in order to be able to handle it
            with Selenium, you must use SELECT class

            What is Select class?
                it is a class coming from Selenium
                it has ready methods in it
                we use it to handle Select dropdowns

       How do you handle select dropdown , explain verbally?
            1.I would create an instance of Select class
            2. And locate the select dropdown, and pass the dropdown webElement into the
            select instance
            3. Then using instance, we can do actions on select dropdowns

       How many ways are there to select an option? ==> 3

       1. selectByIndex -> accepts int arg and selects by index of WebElement
       2. selectByValue -> selects by the value of attribute value
       3. selectByVisibleText -> literally selects  with the text of the option

       How do we get all the options inside of select dropdown?
        -> .getOptions(): this method returns all of the options in a select dropdown
        -> returns list of WebElement

        How do we get which option is selected?
        -> .getFirstSelectedOption(): this method returns currently selected option

    How do you handle Dynamic webElements?

        if attribute values are changing when we refresh the page, it means values
        are dynamic
        we have 2 ways to handle dynamic web elements:

        1. locate one static web Element( u can either locate child"/" or parent"/.." of that
            webElement)
                * if u r coming from parent: "/"single slash to go to child until we reach
                desired webElement
                * if coming from child: "/.." single slash with double dots to go to
                parent until we reach desired webElement

        2. we have 3 xpath locators to handle dynamic attribute values

                    1-> //element[contains(@attribute, 'value')]
                         ex: <div id="abc1632541" name="3175431code"></div>
                         ex: div[contains(@id,'abc')]
                          looking for stable parts of element, text is usually stable

                    2->  //element[startsWith(@attribute, 'value')]
                        ex:  <div id="abc1632541" name="3175431code"></div>
                         ex: div[startsWith(@id,'abc')]

                    3->  //element[endsWith(@attribute, 'value')]
                    ex:  <div id="abc1632541" name="3175431code"></div>
                         ex: div[endsWith(@name,'code')]


      How many different types of dependencies we used in our project?

      so far 3

      what are they?

      1. java-Selenium --> 3.14
      2. BoniGarcia -> WebDriverManager ==> 4.0
      3. TestNG ==> 7.1

      AND TODAY WE ARE ADDING THE 4TH ONE:

      4. JavaFaker
      it is very small java library, used to create fake data for testing purposes
        JAVAFAKER: is used to create fake data for testing purposes.
    -> It is a small library that has the ability to create randomly generated data.
    -> Useful when you have a bunch of inputs that you need to enter on a page.
    -> You can use JavaFaker for this purpose. It will generate random data for you.
        - fullname
        - first name
        - last name
        - address
        - phone number
        - email
        - and dozens of other different options








     */
}
