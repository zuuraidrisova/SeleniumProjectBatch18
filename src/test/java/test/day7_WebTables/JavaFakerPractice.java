package test.day7_WebTables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    /*
 How many different types of denepdencies we used in our project?

      so far 3

      what are they?

      1. java-Selenium
      2. BoniGarcia -> WebDriverManager
      3. TestNG

AND TODAY WE ARE ADDING THE 4TH ONE:

      4. JavaFaker
      it is very small java library, used to create fake data for testing purposes
     */

    @Test
    public void faker_test(){

        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name = " + name);
        String firstName = faker.name().firstName(); // Emory
        System.out.println("firstName = " + firstName);
        String lastName = faker.name().lastName(); // Barton
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAddress = " + streetAddress);
        
        String gameOfThrones = faker.gameOfThrones().quote();
        System.out.println("gameOfThrones = " + gameOfThrones);
        
        String chuckNorris = faker.chuckNorris().fact();
        System.out.println("chuckNorris = " + chuckNorris);
        
      
    }



}
