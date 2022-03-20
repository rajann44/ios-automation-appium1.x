package config;

import java.util.Properties;

public class ConfigKey {

    public static String EXPLICIT_WAIT, DEVICE_NAME, DEVICE_UDID,
            APP_BUNDLE_ID, APP_PATH, PLATFORM_VERSION, XCODE_ORG_SIGNATURE_ID;
    public static boolean RE_INSTALLATION_OF_APP, IS_REAL_DEVICE, WDA_INSTALL_RETRY;

    public static void setConfig(Properties properties){
        EXPLICIT_WAIT = properties.getProperty("explicitWait");
        DEVICE_NAME = properties.getProperty("deviceName");
        DEVICE_UDID = properties.getProperty("deviceUdid");
        APP_BUNDLE_ID = properties.getProperty("appBundleID");
        APP_PATH = properties.getProperty("appPath");
        PLATFORM_VERSION = properties.getProperty("platformVersion");
        RE_INSTALLATION_OF_APP = Boolean.parseBoolean(properties.getProperty("reInstallationOfApp"));
        IS_REAL_DEVICE = Boolean.parseBoolean(properties.getProperty("isRealDevice"));
        XCODE_ORG_SIGNATURE_ID = properties.getProperty("xcodeOrgSignatureId");
        WDA_INSTALL_RETRY = Boolean.parseBoolean(properties.getProperty("wdaInstallRetry"));
    }

}
