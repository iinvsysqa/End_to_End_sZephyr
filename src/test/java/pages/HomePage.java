package pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{
	
	public String userName = loadProp("USERNAME");
	public String emaId = loadProp("EMAILID");
	
	String registerpageexpectedScreenshotPath="./ExpectedScreenshots/registerPage.png";
	String registerpageactualScreenshotPath="./Actual_screenshots/registerPageScreenshot.png";
	String SignInexpectedScreenshotPath="./ExpectedScreenshots/signInpage.png";
	String SignInactualScreenshotPath="./Actual_screenshots/signinpageScreenshot.png";
	String SignUpexpectedScreenshotPath="./ExpectedScreenshots/signUppage.png";
	String SignUpactualScreenshotPath="./Actual_screenshots/signUppageScreenshot.png";
	String AdddeviceExpectedScreenshotPath="./ExpectedScreenshots/Adddevicepage.png";
	String AdddeviceactualScreenshotPath="./Actual_screenshots/adddevicePageScreenshot.png";
	String NextbuttonexpectedScreenshotPath="./ExpectedScreenshots/Nextbuttonpage.png";
	String NextbuttonactualScreenshotPath="./Actual_screenshots/nextbuttonPageScreenshot.png";
	String StartpairingexpectedScreenshotPath="./ExpectedScreenshots/Startpairingpage.png";
	String StartpairingactualScreenshotPath="./Actual_screenshots/startpairingPageScreenshot.png";
	
	
	private AndroidDriver driver;

	@FindBy(xpath="//*[@resource-id='android:id/content']")
	private WebElement fullpage;
	@FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//*[@resource-id='Launch_SignUpLink']")
	private WebElement signUpLink;
	
	@FindBy(xpath = "//*[@resource-id='Add_Devices_ButtonText']")
	private WebElement addDeviceButton;
	@FindBy(xpath = "//*[@resource-id='Pairing_mode_Checkbox']")
	private WebElement checkBoxPairing;
	@FindBy(xpath = "//*[@resource-id='Pairing_mode_ButtonText']")
	private WebElement nextButtonPairing;
	@FindBy(xpath = "//*[@resource-id='Accounts_YourName']")
	private WebElement Usernamefield;

	@FindBy(xpath = "//*[@resource-id='Accounts_YourEmail']")
	private WebElement emailIdfield;

	@FindBy(xpath = "//*[@resource-id='Accounts_Language_Sub_Title']")
	private WebElement languagesubtitle;
	
	@FindBy(xpath = "//*[@resource-id='Accounts_YourAge']")
	private WebElement ageField;
	
	@FindBy(xpath = "//*[@resource-id='Accounts_YourGender']")
	private WebElement genderField;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"English\"]")
	private WebElement languageField;
	
	@FindBy(xpath = "//*[@resource-id='Device_BackIcon']")
	private WebElement backbuttonDevicesettings;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_AlreadyPairedDevice']")
	private WebElement knownDevicePairingbutton;
	
	@FindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	private WebElement permissionallowpopup;
	
	@FindBy(xpath = "//*[@resource-id='QR_Scanner_ScanQr_Text']")
	private WebElement scanQr;
	
	@FindBy(xpath = "//*[@resource-id='QR_Scanner_Steps_Title']")
	private WebElement scanQrTitle;
	
	@FindBy(xpath = "//*[@resource-id='QR_Scanner_Steps_Text1']")
	private WebElement qrStep1;
	
	@FindBy(xpath = "//*[@resource-id='QR_Scanner_Steps_Text2']")
	private WebElement qrStep2;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")
	private WebElement logoutPopupcancelButton;
	
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"Logout\"])[2]")
	private WebElement logoutPopupYesButton;
	
	@FindBy(xpath = "(//android.widget.TextView[@text=\"Logout\"])[1]")
	private WebElement logoutPopupTitle;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Do you want to logout?\"]")
	private WebElement logoutPopupContent;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_Report']")
	private WebElement reportButton;
	//==================================================
	@FindBy(xpath="//*[@resource-id='home_main_on_off_swch']")
	private WebElement deviceONOFFButton;
	
	@FindBy(xpath = "//*[@resource-id='Options_Icon']")
	private WebElement menuBarButton;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/undefined\" and @text=\"\"]")
	private WebElement menuBarButtonafterpairing;
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"com.szephyr:id/undefined\"]")
	private WebElement menuBarButtonafterpairing_withoutconnectivity;
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_accounts']")
	private WebElement Accountinfobutton;
	
	
	@FindBy(xpath = "//*[@resource-id='menu_icon_sharelog']")
	private WebElement sharelog ;
	
	@FindBy(xpath = "//*[@resource-id='Home_StandByIndication']")
	private WebElement Acturnondesc;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please ensure sZephyr is switched ON prior to operating your AC remote\"]")
	private WebElement ActurnOFFdesc;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Searching for sZephyr to establish connection\"]")
	private WebElement Acofflinedesc;
	
	@FindBy(xpath = "//*[@resource-id='Home_StandByIndication']")
	private WebElement Acturnonwithloaddesc;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'V')]")
	private WebElement voltValue;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'W')]")
	private WebElement wattValue;
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'A')]")
	private WebElement currentValue;
	
	@FindBy(xpath = "//*[@resource-id='PairedGeyser_Img_svg_ble_0_blue']")
	private WebElement bleSymbol;
	@FindBy(xpath = "//*[@resource-id='Share_Log']")
	private WebElement shareBtn;
	@FindBy(xpath = "//*[@resource-id='Home_Analytics_Button']")
	private WebElement analyticsBtn;
	@FindBy(xpath = "//*[@resource-id='Home_Maintenance_Button']")
	private WebElement maintainanceBtn;
	@FindBy(xpath = "//*[@resource-id='Home_Navigation_Button']")
	private WebElement schedularBtn;
	@FindBy(xpath = "//*[@resource-id='Home_Notification_Button']")
	private WebElement notificationBtn;
	@FindBy(xpath = "//*[@resource-id='ShareDevice_DeviceName']")
	private WebElement sharepagedevicename;
	@FindBy(xpath = "//*[@resource-id='Header']")
	private WebElement notficationHeader;
	@FindBy(xpath = "//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
//	@FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
	private WebElement devicepermission;
	
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		public void clickokonpopup() {
	clickbyXpath(logoutPopupYesButton, "logout pop-up yes button");
		 
		}
		
	public void clickONOFFButton() {
		expWaitforPairing(deviceONOFFButton);
		clickbyXpath(deviceONOFFButton, " Device ON OFF Button ");
	}
	
	public void clickMenuBarButton() {
		clickbyXpath(menuBarButton, " Menu Bar ");
	}
	public void clickMenuBarButtonafterpairing() throws Exception {
		
		if (isiconDisplayed(menuBarButtonafterpairing, "menu bar after pairing element displayed")) {
			Thread.sleep(5000);
			clickbyXpath(menuBarButtonafterpairing, " Menu Bar ");
			}else if (isiconDisplayed(menuBarButtonafterpairing_withoutconnectivity, "without connectivity menu bar icon")) {
				Thread.sleep(5000);
				clickbyXpath(menuBarButtonafterpairing_withoutconnectivity, " Menu Bar ");
				
			}
	}
	
	public void clickAccountinfobutton() {
		clickbyXpath(Accountinfobutton, " Account info");
	}
	
	public void clickKnownDevicepairingButton() {
		clickbyXpath(knownDevicePairingbutton, "Known device pairing button");
	}
	

	 public void clicksharcelog() {
		expWaitforPairing(sharelog);
		clickbyXpath(sharelog, " sharelog button ");
	 }
	 
	 public void VerifyONdesc()
	 {
	  verifyTextContainsByXpath(Acturnondesc, "Your AC unit is either in standby or powered OFF at the moment","Device on description ");
	 }
	 public void VerifyOFFdesc()
	 {
		 verifyTextContainsByXpath(ActurnOFFdesc, "Please ensure sZephyr is switched ON prior to operating your AC remote","Device off description");
	 }
	   public void killandopen() 
	   {
		   killAndReopenApp();
	   }
	
	   public void disableBLE() throws Exception 
	   {
		   turnOffBT();
	   }
	   public void enableBLE() 
	   {
		   turnOnBT();
	   }
	   public void enableWIFI() 
	   {
		   enableWiFi();
	   }
	   public void disableWIFI() 
	   {
		   disableWiFi();
	   }
	   
	   public void WifiSwitch(String Wifiname,String Wifipassword) throws Exception 
	   {
		   
		   connectToWiFi(Wifiname, Wifipassword);
			Runtime.getRuntime().exec("adb shell am force-stop com.android.settings");
		   if (driver.queryAppState(packages) != ApplicationState.RUNNING_IN_FOREGROUND) {
				driver.activateApp(packages); 
				// Bring it back
//				Thread.sleep(3000);
			}
	   }

	   
	   public void getCurrentvalue() throws InterruptedException {
		   
		   verifyTextContainsByXpath(currentValue, "A","Home page current  value" );
	}
	   public void getVoltvalue() throws InterruptedException {
		   verifyTextContainsByXpath(voltValue, "V","Home page Volt value" );
		   
		   
	   }
	   public void getPowervalue() throws InterruptedException {
		   verifyTextContainsByXpath(wattValue, "W","Home page WATT value" );
		   
	   }
	   public void getbleSymbol() throws InterruptedException {
		   String attribute = bleSymbol.getText();
		   System.out.println(attribute);
	   }
	   
//	   String description[]={"Searching for sZephyr to establish connection","Please ensure sZephyr is switched ON prior to operating your AC remote","Your AC unit is either in standby or powered OFF at the moment","sZephyr and AC turned ON"};
	   
//	   public void checkforDeviceOffstateDescription() {
//		   
//		   String Offstatedescription="Please ensure sZephyr is switched ON prior to operating your AC remote";
//		   String text = ActurnOFFdesc.getText();
//	
//	if (text.contains(Offstatedescription)) {
//		System.out.println("Device is still present ");
//		
//	}
//	else {
//		System.out.println("Device not found");
//	
//}
//	}
//	   public void checkforDeviceOnstateDescriptionwithoutload() {
//		   
//		   String Offstatedescription="Your AC unit is either in standby or powered OFF at the moment";
//		   String text = Acturnondesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
//	   public void checkforDeviceOnstateDescriptionwithload() {
//		   
//		   String Offstatedescription="sZephyr and AC turned ON";
//		   String text = ActurnOFFdesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
//	   public void checkforDeviceofflineDecription() {
//		   
//		   String Offstatedescription="Searching for sZephyr to establish connection";
//		   String text = ActurnOFFdesc.getText();
//		   
//		   if (text.contains(Offstatedescription)) {
//			   System.out.println("Device is still present ");
//			   
//		   }
//		   else {
//			   System.out.println("Device not found");
//			   
//		   }
//	   }
	   public void backnavigation() {

		  clickbyXpath(backbuttonDevicesettings, "clicking on back button");
	}
	   public void clickLogoutButton() {
			clickbyXpath(logoutButton, " Logout button ");
		}
	   public void clickReportButton() {
		   clickbyXpath(reportButton, " Report button ");
	   }
	   
	   public void register_Page_ScreenShot_Check() throws Exception {

		   screenShotsCheck(fullpage,registerpageactualScreenshotPath,registerpageexpectedScreenshotPath,"registerpage");
	}
	   
	   public void SignIn_Page_ScreenShot_Check() throws Exception {
		   clickbyXpath(signInButton, "signinbutton");  
		   screenShotsCheck(fullpage,SignInactualScreenshotPath,SignInexpectedScreenshotPath,"SignIn page");
		   driver.navigate().back();
	   }
	   public void SignUp_Page_ScreenShot_Check() throws Exception {
		   clickbyXpath(signUpLink, "signupbutton");
		   screenShotsCheck(fullpage,SignUpactualScreenshotPath,SignUpexpectedScreenshotPath,"SignUp page");
		   driver.navigate().back();
	   }
	   public void Adddevice_Page_ScreenShot_Check() throws Exception {
		   screenShotsCheck(fullpage,AdddeviceactualScreenshotPath,AdddeviceExpectedScreenshotPath,"Add device page");
	   }
	  

	   public void checkAccountsinfoDefaultValues() {

		   verifyTextContainsByXpath(Usernamefield,userName , "Accounts_info_UserName_field");
		   verifyTextContainsByXpath(emailIdfield,emaId , "Accounts_info_EmailId_field");
		   verifyTextContainsByXpath(ageField,"" , "Age field");
		   verifyTextContainsByXpath(genderField,"" , "Gender field");
		   verifyTextContainsByXpath(languageField,"English" , "Lanugage field");
		   
	}
	   public void checkAdddevicePageDefaultvalues() {
		   clickonAllowpop_up();
		   verifyTextContainsByXpath(scanQr,"Scan QR" , "Qr title");
		   verifyTextContainsByXpath(scanQrTitle,"Steps" , "subtitle");
		   verifyTextContainsByXpath(qrStep1,"1 : Get Admin's QR code from their application using Share device icon in their homepage" , "Step1 of QR scan");
		   verifyTextContainsByXpath(qrStep2,"2 : Scan QR to pair device in an instant" , "Step2 of QR scan");
	   }
	   public void checkLogoutcontents() {

		   verifyTextContainsByXpath(logoutPopupTitle,"Logout","Logout Title" );
		   verifyTextContainsByXpath(logoutPopupContent,"Do you want to logout?","Logout content" );
		   clickbyXpath(logoutPopupcancelButton,"Logout no pop up Button" );
	}
	
	   public void clickShareicon() {
		   clickbyXpath(shareBtn, "share  button");
		  
	}

	   public void clickandVerifyNotificationPage() {
		   clickbyXpath(notificationBtn, "Notification  button");
		   verifyTextContainsByXpath(notficationHeader, "Notifications", "Notifications header");
	}
	   
		private void clickonAllowpop_up() {
			if (isiconDisplayed(devicepermission, "Ok_pop-up")) {
				clickbyXpath(devicepermission, "ok pop-up");
			}
		}
	   
}

