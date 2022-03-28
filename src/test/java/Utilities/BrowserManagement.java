package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import Utilities.*;
import pages.Careers;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BrowserManagement {

    static String baseUrl = "https://www.ilabquality.com/";
    static String  driverPathChrome = "C://Users//Admin 1//OneDrive - GoldenRule//Attachments//lib//chromedriver.exe";
    static String driverPathEdge = "C://Users//Admin 1//OneDrive - GoldenRule//Attachments//lib//msedgedriver.exe";
    public  static WebDriver driver ;

    public static void LaunchBrowser(String Option) throws Exception
    {
        switch(Option){
            case "Chrome":
                LaunchChromeBrowser();
                break;
            case "MicrosoftEdge":
                LaunchEdgeBrowser();
                break;
            default :
                System.out.println("Browser : " +Option + "is invalid, launching in chrome");
                LaunchChromeBrowser();
        }
    }

    public static void LaunchChromeBrowser ()
    {
        try{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            driver.get(baseUrl);

            CommonFunctions.ValidatePageTitle("iLAB – Software Quality Assurance");

            Thread.sleep(10000);
        }catch (Exception e)
        {
            Reporting.test.log(LogStatus.FAIL,"Failed to launch Chrome Browser");
            Reporting.test.log(LogStatus.INFO,e);
        }

    }

    public static void LaunchEdgeBrowser() throws Exception
    {
        try {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseUrl);

            CommonFunctions.ValidatePageTitle("iLAB – Software Quality Assurance");

            Thread.sleep(10000);
        }catch (Exception e)
        {
            Reporting.test.log(LogStatus.FAIL,"Failed to launch Edge Browser");
            Reporting.test.log(LogStatus.INFO,e);
        }

    }


}
