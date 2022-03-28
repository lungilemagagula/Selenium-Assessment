package test;
import java.util.concurrent.TimeUnit;

import Utilities.CommonFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.BrowserManagement;
import Utilities.Reporting;
import pages.ApplyOnlinePage;
import pages.Careers;
import pages.HomePage;

public class TestingCode {

    String Browser = "Chrome";

    HomePage objHome;
    Careers objCareers;
    ApplyOnlinePage objApplyOnline;

    @BeforeTest
    public void beforeTest() throws Exception{
        System.out.println("before test");
        Reporting.report = new ExtentReports("C://Users//Admin 1//OneDrive - GoldenRule//Attachments//Reporting//Report.html",true); //TRUE BECAUSE i WANT IT TO FLUSH ALL THE PREVIOUSLY gENERATED REPORTS
        Reporting.test = Reporting.report.startTest("Apply For A Job");
        BrowserManagement.LaunchBrowser(Browser);
    }

    @Test (priority= 1)
    public void HomePageSimulations() throws Exception {
        objHome = new HomePage(BrowserManagement.driver);
        objHome.ClickCareersBtn();
    }
    @Test (priority= 2)
    public void CareersPageSimulations() throws Exception {
        objCareers = new Careers(BrowserManagement.driver);
        objCareers.NavigateCareersPage();
    }
    @Test (priority= 3)
    public void ApplyOnline() throws Exception
    {
        objApplyOnline = new ApplyOnlinePage(BrowserManagement.driver);
        objApplyOnline.ApplicationProcess();
    }

    @AfterTest
    public void afterTest() {
        BrowserManagement.driver.quit();
        System.out.println("after test");
        Reporting.report.endTest(Reporting.test);
        Reporting.report.flush();
    }

}
