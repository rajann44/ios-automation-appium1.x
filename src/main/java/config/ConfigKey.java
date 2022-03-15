package config;

import java.util.Properties;

public class ConfigKey {

    public static String EXPLICIT_WAIT, DEVICE_NAME, DEVICE_UDID,
            APP_BUNDLE_ID, APP_PATH, PLATFORM_VERSION;
    public static boolean NO_RE_INSTALLATION_OF_APP;

    public static void setConfig(Properties properties){
        EXPLICIT_WAIT = properties.getProperty("explicitWait");
        DEVICE_NAME = properties.getProperty("deviceName");
        DEVICE_UDID = properties.getProperty("deviceUdid");
        APP_BUNDLE_ID = properties.getProperty("appBundleID");
        APP_PATH = properties.getProperty("appPath");
        PLATFORM_VERSION = properties.getProperty("platformVersion");
        NO_RE_INSTALLATION_OF_APP = Boolean.parseBoolean(properties.getProperty("noReInstallationOfApp"));
    }

}
