package test.day6_TestNG_DropDowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class testNGPractice {

        @AfterClass
        public void after_class(){

            System.out.println("After Class is running...");
        }
        @BeforeClass
        public void before_class(){

            System.out.println("Before Class is running...");
        }
        @BeforeMethod
        public void setUp(){

            System.out.println("Before test running...");
        }
        @Test
        public  void test1(){

            System.out.println("Test 1 running...");

            String actualTitle = "Homepage";//driver.getTitle();
            String expectedTitle = "Homepage";

            Assert.assertEquals(actualTitle, expectedTitle);

            /*
            if(actualTitle.equals(expectedTitle)){

                System.out.println("Title Verification PASSED!");

            }else{

                System.out.println("Title Verification FAILED");
            }

             */
        }

        @Ignore
        @Test
        public void test2(){

            System.out.println("Test 2 running...");

            Assert.assertEquals("string1","string2","String verification on test 2 failed");
        }
        //@Test
        public void test3(){

            System.out.println("Test 3 running...");

            String actualTitle = "Amazon prime";
            String expectedInTitle = "prime";

            //if boolean value we pass in assertTrue is true, it will pass, else fail
          //  Assert.assertTrue(actualTitle.contains(expectedInTitle));

            String testString = "ahdfj";

          // Assert.assertTrue(actualTitle.contains(testString));

            System.out.println("Just checking if this line runs...");

            Assert.assertFalse(actualTitle.contains(testString));

        }


        @AfterMethod
        public void tearDown(){

            System.out.println("After test running...");
        }
}
