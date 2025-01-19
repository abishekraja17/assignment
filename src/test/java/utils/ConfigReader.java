package utils;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/application.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Property file not found" + e);
        }
    }

    public ConfigReader() throws FileNotFoundException {
    }

    public static String getProperty(String key) throws IOException {
        return properties.getProperty(key).toString();
    }
}
