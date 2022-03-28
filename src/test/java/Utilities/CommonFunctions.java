package Utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
    HomePage objHome;



    public static void ValidatePageTitle(String Expected) throws Exception
    {
        Reporting.test.log(LogStatus.INFO,"Get Page Title");
        String title = BrowserManagement.driver.getTitle();
        if (title.equalsIgnoreCase( Expected))
        {
            Reporting.test.log(LogStatus.PASS,Reporting.test.addScreenCapture(Reporting.CaptureScreenShot()) + title);
        } else
        {
            Reporting.test.log(LogStatus.FAIL,title);
            System.out.println(title);
        }
    }
    public static void ClickBtn(WebElement Elem, String PageTitle){
        try{
            if (Elem.isEnabled() && Elem.isDisplayed())
            {
                Elem.click();
                BrowserManagement.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Reporting.test.log(LogStatus.PASS, Reporting.test.addScreenCapture(Reporting.CaptureScreenShot()) + "Click " + Elem );
                CommonFunctions.ValidatePageTitle(PageTitle);
            }
        }catch(Exception e)
        {
            Reporting.test.log(LogStatus.FAIL,"Failed to click Element");
            Reporting.test.log(LogStatus.INFO,e);
        }
    }
    public static void SetText(WebElement Elem, String TextToSet){
        try{
            if (Elem.isEnabled() && Elem.isDisplayed())
            {
                Elem.sendKeys(TextToSet);
                BrowserManagement.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Reporting.test.log(LogStatus.PASS, Reporting.test.addScreenCapture(Reporting.CaptureScreenShot()) + "Enter Text : " + Elem );

            }
        }catch(Exception e)
        {
            Reporting.test.log(LogStatus.FAIL,"Failed to set text");
            Reporting.test.log(LogStatus.INFO,e);
        }
    }

    public static String GenerateNumber()
    {
        Random rnd = new Random();
        int MSISDN = rnd.nextInt(999999999);
        return String.format("%09d",  MSISDN);
    }

    public static void GetElement( )
    {

    }

}
