package test.day11_pageObjectModel;

public class recapNotes {
    /*
    JULY 6TH, MONDAY-FUNDAY
TODAY'S SCHEDULE
-Recap about last class
-Solve tasks
-Page object model design pattern
-PracticeS
===========================================================================
HOW DO YOU HANDLE DOWNLOADS WITH SELENIUM?
    -> WE DON'T/CAN'T.
    -> Selenium cannot handle downloads except for the clicking the link part.
    -> Since selenium can only work with browsers, and the file is downloaded to the computer file directory, we cannot verify a download using selenium.
HOW DO WE HANDLE UPLOADS WITH SELENIUM?
    -> We can upload files using selenium by sending the path of the file into the upload web element.
    syntax: uploadWebElement.sendKeys("path of the file");
===========================
JAVASCRIPTEXECUTOR:
    -> WHAT IS JAVASCRIPTEXECUTOR?
        - Just an interface with two methods.
    -> What can we do with these methods?
        - JavaScriptExecutor allows us to execute/inject javascript code into our java/selenium code.
    -> When do we need this?
        - Whenever selenium is not capable of some of the actions we need to do, such as scrolling down.
=================
ACTIONS:
    -> WHY DO WE NEED ACTIONS CLASS? WHAT DOES IT DO?
    -> Actions class allows us to handle complex/advanced mouse and keyboard actions. Such as:
        -> hover over : moveToElement
        -> right click: contextClick
        -> dragAndDrop: allows us to drag and drop a web element
        -> clickAndHold: clicks onto something and waits for next command
        -> release :
    How do we use Actions methods?
        1- To be able to use any Actions method, we need to create the instance of the actions class.
        2- Then we need to pass the current driver instance into the constructor.
        3- We must use : perform() method at the end to be able to perform any actions method.
====================================================
How many ways to scroll down?
    1- Using JavaScriptExecutor
    2- Using Actions moveToElement method.
====================================================
     */
}
