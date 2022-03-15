package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {

    static Properties prop;
    static String filePath = System.getProperty("user.dir")+ "/src/main/java/config/config.properties";

    public static Properties readPropertiesFile(){
        prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            prop.load(inputStream);
            ConfigKey.setConfig(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

}
