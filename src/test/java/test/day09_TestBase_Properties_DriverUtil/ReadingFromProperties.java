package test.day09_TestBase_Properties_DriverUtil;

import org.testng.annotations.Test;
import utilities.configurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void readingFrom_properties_file() throws IOException {

       // Properties class object allows us to read from configuration.properties
        Properties properties = new Properties();


        //we need to show where the file is stored
        //we need the path of the file
        String path = "configuration.properties";

        //We need to open this configuration.properties file in java memory
        FileInputStream file = new FileInputStream(path);

        //we need to load the opened file into properties object

        properties.load(file);

        //we can read the configuration.properties file using properties object
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));


    }


    @Test
    public void using_configuration_reader_utility(){

        System.out.println("configurationReader.getProperty(\"browser\") = " + configurationReader.getProperty("browser"));

        System.out.println("configurationReader.getProperty(\"username\") = " + configurationReader.getProperty("username"));

        System.out.println("configurationReader.getProperty(\"password\") = " + configurationReader.getProperty("password"));


    }
}
