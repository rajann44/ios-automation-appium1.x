package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.AppDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    static String filePath;

    public static String captureScreenshot(String fileName){

        File file = ((TakesScreenshot) AppDriver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            filePath = System.getProperty("user.dir") + "/reports/screenshots/"+fileName+".png";
            FileUtils.copyFile(file,new File(filePath));
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
