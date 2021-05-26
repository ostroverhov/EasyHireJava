package framework.utils;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Logger logger = Logger.getInstance();
    private static final String pathToConfig = "src/main/resources/config.properties";
    private static final String pathToTestUser = "src/test/resources/TestData.json";

    public static String getParameter(String parameter) {
        logger.info("Get parameter [%s]", parameter);
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToConfig);
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }

    public static <T> T getObjectFromJson(Class<T> targetClass) {
        logger.info("Get object from json");
        FileReader reader = null;
        try {
            reader = new FileReader(pathToTestUser);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert reader != null;
        return new Gson().fromJson(reader, targetClass);
    }
}
