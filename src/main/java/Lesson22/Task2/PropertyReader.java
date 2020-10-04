package Lesson22.Task2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader loadProperties = null;
    private static Properties properties = null;
    private static InputStream inputStream = null;

    private PropertyReader(String propertyFileName) {
        inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(propertyFileName);
    }

    public static PropertyReader getInstance() {
        if (loadProperties == null) {
            loadProperties = new PropertyReader("con.properties");
        }
        return loadProperties;
    }

    public String getValueFromProperty(String key) {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
