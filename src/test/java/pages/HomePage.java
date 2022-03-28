package pages;

import Utilities.BrowserManagement;
import Utilities.CommonFunctions;
import Utilities.Reporting;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

   WebDriver driver;

   public  HomePage(WebDriver dr)
   {
      this.driver =dr;
      PageFactory.initElements(driver,this);
   }
   @FindBy(linkText= "CAREERS")
   WebElement CareersLink;

   //By CareersLink = By.linkText("CAREERS");

   public void ClickCareersBtn() {
      CommonFunctions.ClickBtn(CareersLink, "CAREERS – iLAB");
   }
}
