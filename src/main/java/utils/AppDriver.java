package utils;

import config.ConfigKey;
import config.ConfigHandler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppDriver {

    protected static AppiumDriver<MobileElement> driver = null;
    public static DesiredCapabilities caps = new DesiredCapabilities();
    static URL url;

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            //AppiumServerBuilder.startAppiumServer();
            ConfigHandler.readPropertiesFile();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            caps.setCapability(IOSMobileCapabilityType.SHOW_XCODE_LOG, true);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigKey.PLATFORM_VERSION);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigKey.DEVICE_NAME);
            caps.setCapability(MobileCapabilityType.UDID, ConfigKey.DEVICE_UDID);


            /********WHEN USING REAL DEVICE*********/
            if (ConfigKey.IS_REAL_DEVICE){
                caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID,ConfigKey.XCODE_ORG_SIGNATURE_ID);
                caps.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID,"iPhone Developer");
            }
            //caps.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "com.rajan.WebDriverAgentRunner");
            //caps.setCapability("noReset", true);
            //caps.setCapability("derivedDataPath", "/Users/rajan/Library/Developer/Xcode/DerivedData/WebDriverAgent-UNIQUE_ID");

            /********Use Below Capability if any issue when Launching WDA*********/
            //caps.setCapability(IOSMobileCapabilityType.WDA_STARTUP_RETRIES, "5");
            //caps.setCapability(IOSMobileCapabilityType.WDA_STARTUP_RETRY_INTERVAL, "20000");
            //caps.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, "true");

            /********Use Below Capability to automatically handle alert*********/
            //caps.setCapability(IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, "true");
            //caps.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, "true");

            if(ConfigKey.RE_INSTALLATION_OF_APP){
                caps.setCapability(MobileCapabilityType.APP, ConfigKey.APP_PATH);
                caps.setCapability(IOSMobileCapabilityType.IOS_INSTALL_PAUSE, "8000");
            }

            //Pre-Req: App should be already installed on iOS
            if(!ConfigKey.RE_INSTALLATION_OF_APP){
                caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ConfigKey.APP_BUNDLE_ID);
            }

            //caps.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG, "true");
            //caps.setCapability("wdaLocalPort", "10001");
            //caps.setCapability("webkitDebugProxyPort", "11001");

            //driver = new IOSDriver<>(AppiumServerBuilder.getServerURL(), caps);
            driver = new IOSDriver<>(getDriverURL(), caps);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigKey.EXPLICIT_WAIT), TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    public static AppiumDriver<MobileElement> getSafariDriver() {
        if (driver == null) {
            //AppiumServerBuilder.startAppiumServer();
            ConfigHandler.readPropertiesFile();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
            caps.setCapability("safari:useSimulator", "true");
            caps.setCapability("appium:nativeWebTap", "true");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigKey.PLATFORM_VERSION);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigKey.DEVICE_NAME);
            driver = new IOSDriver<>(getDriverURL(), caps);
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigKey.EXPLICIT_WAIT), TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    private static URL getDriverURL() {
        try { url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } return url;
    }

    /**
     * Close the App
     */
    public static void closeTheApp() {
        driver.closeApp();
    }

    /**
     * Launches the App
     */
    public static void launchTheApp() {
        driver.launchApp();
    }

    /**
     * Reset the App
     */
    public static void resetTheApp() {
        driver.resetApp();
    }

    /**
     * Check App State
     */
    public static boolean isAppOpen() {
        return driver.queryAppState(ConfigKey.APP_BUNDLE_ID).equals("RUNNING_IN_FOREGROUND");
    }

    /**
     * Terminate The App
     */
    public static void terminateApp(){
        driver.terminateApp(ConfigKey.APP_BUNDLE_ID);
    }

    /**
     * Activate The App
     */
    public static void activateApp(){
        driver.activateApp(ConfigKey.APP_BUNDLE_ID);
    }

}
