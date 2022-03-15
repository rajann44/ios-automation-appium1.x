package helper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;
import java.util.HashMap;

public class AppServerBuilder {

    private static AppiumDriverLocalService server;

    //Start the server on any free port
    public static void startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
    }

    //Stops the server
    public static void stopAppiumServer() {
        server.stop();
    }

    //Returns the server url
    public static URL getServerURL() {
        return server.getUrl();
    }

}
