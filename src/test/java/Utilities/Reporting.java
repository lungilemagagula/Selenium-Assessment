package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Utilities.BrowserManagement.*;

import java.io.File;
import java.io.IOException;


public class Reporting {
    public static ExtentReports report;
    public static ExtentTest test;

    public static String CaptureScreenShot() throws IOException {

        //Capturing screenshot and saving it as file format
        File srcfile = ((TakesScreenshot) BrowserManagement.driver).getScreenshotAs(OutputType.FILE);
        //copy screenshot to desired location using copy file method
        File DestinationFile = new File("C://Users//Admin 1//OneDrive - GoldenRule//Attachments//Reporting//images//" + System.currentTimeMillis() +".png");

        String absolutepath = DestinationFile.getAbsolutePath();
        FileUtils.copyFile(srcfile,DestinationFile);
        return absolutepath;

    }
}
