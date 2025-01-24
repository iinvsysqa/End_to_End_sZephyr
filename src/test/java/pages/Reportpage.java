package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import wrappers.MobileAppWrappers;

public class Reportpage extends MobileAppWrappers {
	
	public String emaId = loadProp("EMAILID");
	
	@FindBy(xpath = "//android.widget.TextView[@text='']")
	private WebElement deviceSettingsButton;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_Report']")
	private WebElement ClickReportpage;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Select issue type\"]")
	private WebElement Clickissuetype;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"App issue\"]")
	private WebElement ClickAppissue;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Select your device name\"]")
	private WebElement Clickdevicename;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"nee_1\"]")
	private WebElement ClickIssuename;
	
	@FindBy(xpath = "//*[@resource-id='Report_Your_Issue']")
	private WebElement ClickIssuedescription;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"Report_FewTimes_Button\"]")
	private WebElement ClickIssueobsserved;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"com.szephyr:id/Report_IssueObserve_Sub_Title\"]/android.view.ViewGroup")
	private WebElement Clickenterdate;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"18 September 2024\"]")
	private WebElement Enterdate;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement Clickokbutton;
	
	@FindBy(xpath = "//*[@resource-id='Report_UploadScreenshot_plus']")
	private WebElement Uploadscreenshort;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_all_button\"]")
	private WebElement Clickallowall;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[2]")
	private WebElement selectphotos;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.providers.media.module:id/button_add\"]")
	private WebElement Clickaddoption;
	
	@FindBy(xpath = "//*[@resource-id='Report_Submit_ButtonText']")
	private WebElement Clicksubmitbutton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Select issue type\"]")
	private WebElement issueType;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Device issue\"]")
	private WebElement issuetypeDropdown1;
	@FindBy(xpath = "//android.widget.TextView[@text=\"App issue\"]")
	private WebElement issuetypeDropdown2;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Others\"]")
	private WebElement issuetypeDropdown3;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Select your device name\"]")
	private WebElement deviceName;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"No device found\"]")
	private WebElement devicedropdown;
	
	@FindBy(xpath = "//*[@resource-id='Report_Your_Issue']")
	private WebElement IssueDescriptionplaceholder;
	
	@FindBy(xpath = "//*[@resource-id='Report_Email_Text']")
	private WebElement emailaddress;
	
	@FindBy(xpath = "//*[@resource-id='Header']")
	private WebElement reportissueTitle;
	
	@FindBy(xpath = "//*[@resource-id='Report_UploadScreenshot_plus']")
	private WebElement plusbutton;
	
	private AndroidDriver driver;
	

		
		public Reportpage(AndroidDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void ClickReportpage() {	
			clickbyXpath(ClickReportpage, " Report page button ");
		}
		
		public void Clickissuetype() {	
			clickbyXpath(Clickissuetype, " Click Issue Type ");
		}
		
		public void ClickAppissue() {	
			clickbyXpath(ClickAppissue, " Click App Issue ");
		}
		
		public void Clickdevicename() {	
			clickbyXpath(Clickdevicename, " Click Device Name ");
		}
		
		public void ClickIssuename() {	
			clickbyXpath(ClickIssuename, " Click Issue Name ");
		}
		
		public void ClickIssuedescription() {	
			clickbyXpath(ClickIssuedescription, " Click Issue Description ");
		}
		
		public void sendDesscription() {	
			ClickIssuedescription.sendKeys("App is not working properly");
		}
		
		public void ClickIssueobsserved() {	
			clickbyXpath(ClickIssueobsserved, " Click Issue Obsserved ");
		}
		
		public void Clickenterdate() {	
			clickbyXpath(Clickenterdate, " Click date option ");
		}
		
		public void Enterdate() {	
			clickbyXpath(Enterdate, " Enter Date ");
		}
		
		public void Clickokbutton() {	
			clickbyXpath(Clickokbutton, " Click OK Button ");
		}
		
		public void Uploadscreenshort() {	
			clickbyXpath(Uploadscreenshort, " Upload Screen Short ");
		}
		
		public void Clickallowall() {	
			clickbyXpath(Clickallowall, " Click Allow ALL ");
		}
		
		public void selectphotos() {	
			clickbyXpath(selectphotos, " Select Photos ");
		}
		

		public void Clickaddoption() {	
			clickbyXpath(Clickaddoption, " Select Add Option ");
		}
		
		public void Clicksubmitbutton() {	
			clickbyXpath(Clicksubmitbutton, " Clicl Submit Button ");
		}
		public void scrolltoElement(WebElement element) {

			driver.findElementByAndroidUIAutomator(
	                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"Report_UploadScreenshot_plus\"))"
	            );

	            // Click the element after scrolling to it
	            element.click();
		}
		
		
		public void Reportanissuepagecontents() {

			verifyTextContainsByXpath(issueType,"Select issue type" , "issue type default content");
			clickbyXpath(issueType, "issuetype");
			verifyTextContainsByXpath(issuetypeDropdown1,"Device issue" , "Device issue option1");
			verifyTextContainsByXpath(issuetypeDropdown2,"App issue" , "Device issue option2");
			verifyTextContainsByXpath(issuetypeDropdown3,"Others" , "Device issue option3");
			clickbyXpath(issuetypeDropdown3, "issuetype others");
			
			
			verifyTextContainsByXpath(deviceName,"Select your device name" , "default content on device name");
			clickbyXpath(deviceName, "device name");
			verifyTextContainsByXpath(devicedropdown,"No device found" , "dropdown of device name");
			clickbyXpath(devicedropdown, "device name in dropdown");
			 verifyTextContainsByXpath(IssueDescriptionplaceholder, "Please explain your issue", "placeholder of description");
			 verifyTextContainsByXpath(emailaddress, emaId, "email address");
			
			 
			 scrolltoElement(plusbutton);;
			 driver.navigate().back();
			 verifyTextContainsByXpath(reportissueTitle, "Report an issue", "Report issue title");
			
			
		}

}
