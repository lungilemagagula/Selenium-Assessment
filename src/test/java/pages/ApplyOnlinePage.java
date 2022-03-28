package pages;

import Utilities.CommonFunctions;
import Utilities.ExcelUtils;
import Utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ApplyOnlinePage {
    WebDriver driver;
    @FindBy(xpath = "//a[@class='wpjb-button wpjb-form-toggle wpjb-form-job-apply']")
    WebElement ApplyOnlineBtn;
    @FindBy(xpath = "//input[@id='applicant_name']")
    WebElement TxtFirstName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement TxtEmail;
    @FindBy(xpath = "//input[@id='phone']")
    WebElement TxtPhone;
    @FindBy(xpath = "//input[@id='wpjb_submit']")
    WebElement SendBtn;
    @FindBy(xpath = "//*[@class='wpjb-errors']")
    WebElement ErrorMessage;

    public static String ExpectedErrorMsg= "You need to upload at least one file.";
    public static String ActualErrorMsg= null;

    public  ApplyOnlinePage(WebDriver dr)
    {
        this.driver =dr;
        PageFactory.initElements(driver,this);
    }

    public void ApplicationProcess () throws Exception
    {

        CommonFunctions.ClickBtn(ApplyOnlineBtn,"Interns – BSC Computer Science, National Diploma: IT Development Graduates – iLAB");
        CommonFunctions.SetText(TxtFirstName, "Lungile");
        CommonFunctions.SetText(TxtEmail, "automationAssessment@iLABQuality.com");
        CommonFunctions.SetText(TxtPhone, "0"+ CommonFunctions.GenerateNumber());
        CommonFunctions.ClickBtn(SendBtn,"Interns – BSC Computer Science, National Diploma: IT Development Graduates – iLAB");

        ActualErrorMsg = ErrorMessage.getText().toString();
        Assert.assertEquals(ExpectedErrorMsg,ActualErrorMsg);
        Reporting.test.log(LogStatus.INFO,Reporting.test.addScreenCapture(Reporting.CaptureScreenShot()) + "Check if Assertion passed");

    }

}
