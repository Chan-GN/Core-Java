package collections;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo2 {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./resources/config.properties"));

        System.out.println("name = " + properties.getProperty("name"));
        System.out.println("age = " + properties.getProperty("age"));
    }

}
