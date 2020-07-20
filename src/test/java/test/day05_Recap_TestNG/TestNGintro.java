package test.day05_Recap_TestNG;

public class TestNGintro {
    /*
    TESTNG --> NG STANDS FOR NEXT GENERATION


WE ARE NOW ADDING TESTNG LIBRARY TO OUR PROJECT
	1- GO TO MVNREPOSITORY.COM
	2- Type : "TestNG" into the search box
	3- Get the first dependency
	4- Add it into our project pom.xml file


If your TestNG dependency is still RED
	 Right click on project name > MAVEN > Re-import

TestNG ->

	- Is a unit testing tool
	- Allows us to create test structure using annotations

ANNOTATIONS:
	-> What are annotations?
		- Annotations are a way of controlling the flow of tests.

1- @Test :
	 -> Allows us to create TestNG tests
	 -> We create java methods, and put @Test on top of it
	 -> Import from TestNG
	 -> That method becomes a TestNG test
	 -> Therefore we can run independent tests without needing main method.


2- @BeforeMethod:
	 -> This annotation makes the method run before each @Test in the class
	 -> You declare and write it just once, but it will be ran however many times
	  you have @Test in the class.

	In which case this is useful?
	 -> This is useful when you want to do any driver setups.
	  ex:
	  	-> creating and instantiang webDriver
	  	-> opening browser

3- @AfterMethod:
	-> This annotation makes the method run AFTER each @Test in the class
	 -> You declare and write it just once, but it will be ran however many times you
	 have @Test in the class.

	In which case this is useful?
	 -> This is useful when you want to do tearDown stuff.
	 -> When you are finalizing your method, you want to close drivers, browsers etc.
	  ex:
	  	-> closing quitting driver
	  	-> closing browser

     */
}
