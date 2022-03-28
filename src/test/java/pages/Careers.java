package pages;

import Utilities.CommonFunctions;
import Utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Careers {
    WebDriver driver;

    @FindBy(linkText= "South Africa")
    WebElement RegionLink;
    @FindBy(xpath = "((//a[@class='wpjb-job_title wpjb-title'])[1])")
    WebElement FirstJob;

    public  Careers(WebDriver dr)
    {
        this.driver =dr;
        PageFactory.initElements(driver,this);
    }


    public void NavigateCareersPage(){
        CommonFunctions.ClickBtn(RegionLink,"SOUTH AFRICA – iLAB");
        CommonFunctions.ClickBtn(FirstJob,"Interns – BSC Computer Science, National Diploma: IT Development Graduates – iLAB");
    }


}
