package test.day09_TestBase_Properties_DriverUtil;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_test(){

        //.getProperty(Key) ==> is accepting a key and returns its value

        //key=value
        //name=john
        //browser=chrome

        System.out.println("System.getProperty(\"os_name\") = " + System.getProperty("os.name"));

        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));


    }

}

