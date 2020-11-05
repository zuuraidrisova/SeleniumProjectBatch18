package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configurationReader{
    /*
/1- We created properties object.
//2- We got our path and store in String
//3- We need to open the file
//4- We need to load the file
//5- close.file
     */

    //we create properties object
    private static Properties properties = new Properties();

    static{
        //get the path and store in string
        String path = "configuration.properties";


        try {
            //we need to open the file
            FileInputStream file = new FileInputStream(path);

            // we need to load the file
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {

            System.out.println("Properties file not found!");
        }

    }

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }


}
