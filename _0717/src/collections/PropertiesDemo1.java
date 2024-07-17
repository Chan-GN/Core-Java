package collections;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo1 {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement().toString();
            System.out.println("key = " + key);
            System.out.println("value = " + System.getProperty(key));
        }
    }

}
