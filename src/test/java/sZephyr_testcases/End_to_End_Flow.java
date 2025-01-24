package sZephyr_testcases;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import pages.AccountsInfoPage;
import pages.AddDevicePage;
import pages.Analytics;
import pages.DeviceMenuPage;
import pages.HomePage;
import pages.LandingPage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.Szephyr_info_Page;
import utils.logReadandWrite;
import pages.OtpPage;
import pages.Reportpage;
import pages.Schedularpage;
import wrappers.MobileAppWrappers;

import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

public class End_to_End_Flow extends MobileAppWrappers {

	public String userName = loadProp("USERNAME");
	public String emaId = loadProp("EMAILID");
	
	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	AddDevicePage adddevicepage;
	AccountsInfoPage accountinfopage;
	DeviceMenuPage devicesettingpage;
	SignUpPage signuppage;
	Reportpage reportpage;
	DeviceMenuPage devicemenupage;
	Szephyr_info_Page sZephyrinfopage;
	Analytics analyticspage;
	Schedularpage schedularpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "End To End Testing";
		//check login username and Accounts info username are same or not 
		//check for language selection 
		//pair with device try to del account and check for popup and try to remove device and try to del acnt and check add device page .

		testDescription = "End to End Testing Flow";
	}

//Before starting delete your account "testuser007"
	@Test(priority = 0)
	public void homePageUICheck() throws Exception {
		initAndriodDriver();
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);
		signuppage = new SignUpPage(driver);
		reportpage= new Reportpage(driver);
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		sZephyrinfopage = new Szephyr_info_Page(driver);
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
			readwrite.openPort();
			readwrite.write("reboot\r");
			Thread.sleep(3000);

			//home page ui check 
			homepage.register_Page_ScreenShot_Check();
			homepage.SignIn_Page_ScreenShot_Check();
			homepage.SignUp_Page_ScreenShot_Check();
			landingpage.clickSignUpLink();
			signuppage.enterUserName(userName);
			signuppage.enterEmailId(emaId);
			signuppage.clickSignUpTCCheckBox();
			signuppage.clickSignUpButton();
			otppage.verifyOTPVerificationTitle("OTP Verification");
			otppage.enterOTPField1("1");
			otppage.enterOTPField2("2");
			otppage.enterOTPField3("3");
			otppage.enterOTPField4("4");
			otppage.submitButton();
			adddevicepage.verifyAddDevicePage("Add Device");
			homepage.Adddevice_Page_ScreenShot_Check();
			//menubar navigation check
			homepage.clickMenuBarButton();
			homepage.clickAccountinfobutton();
			homepage.checkAccountsinfoDefaultValues();
			homepage.backnavigation();
			
			homepage.clickMenuBarButton();
			homepage.clickKnownDevicepairingButton();
			homepage.checkAdddevicePageDefaultvalues();
			homepage.backnavigation();
			
			homepage.clickMenuBarButton();
			homepage.clickLogoutButton();
			homepage.checkLogoutcontents();
			
			
			homepage.clickMenuBarButton();
			homepage.clickReportButton();
			reportpage.Reportanissuepagecontents();
			homepage.backnavigation();
			
			
			//delete account
			homepage.clickMenuBarButton();
			homepage.clickAccountinfobutton();
			accountinfopage.deleteaccount_toregisterpage();
			
			
			//resignin
			landingpage.clickSignInButton();
			loginpage.enterUserName(userName);
			loginpage.clickSignInButton();
			loginpage.checkUserNameNotFoundToast("User Not Found");
			driver.navigate().back();
			
			//user creation
			landingpage.clickSignUpLink();
			signuppage.enterUserName(userName);
			signuppage.enterEmailId(emaId);
			signuppage.clickSignUpTCCheckBox();
			signuppage.clickSignUpButton();
			otppage.verifyOTPVerificationTitle("OTP Verification");
			otppage.enterOTPField1("1");
			otppage.enterOTPField2("2");
			otppage.enterOTPField3("3");
			otppage.enterOTPField4("4");
			otppage.submitButton();
			adddevicepage.verifyAddDevicePage("Add Device");
			
			//logout 
			homepage.clickMenuBarButton();
			homepage.clickLogoutButton();
			homepage.clickokonpopup();
			
			
			//login
			landingpage.clickSignInButton();
			loginpage.enterUserName(userName);
			loginpage.clickSignInButton();
			otppage.verifyOTPVerificationTitle("OTP Verification");
			otppage.enterOTPField1("1");
			otppage.enterOTPField2("2");
			otppage.enterOTPField3("3");
			otppage.enterOTPField4("4");
			otppage.submitButton();
			adddevicepage.verifyAddDevicePage("Add Device");
			
			
			//menubar navigation check
			homepage.clickMenuBarButton();
			homepage.clickAccountinfobutton();
			homepage.checkAccountsinfoDefaultValues();
			homepage.backnavigation();
			
			homepage.clickMenuBarButton();
			homepage.clickKnownDevicepairingButton();
			homepage.checkAdddevicePageDefaultvalues();
			homepage.backnavigation();
			
			homepage.clickMenuBarButton();
			homepage.clickLogoutButton();
			homepage.checkLogoutcontents();
			
			
			homepage.clickMenuBarButton();
			homepage.clickReportButton();
			reportpage.Reportanissuepagecontents();
			homepage.backnavigation();
			
			
			readwrite.closePort();
		}
		catch (Exception e) {
			readwrite.write("factory_reset\r");		
			readwrite.closePort();
			fail(e);
		}
	}
	
	//Before starting reset device via app.
	@Test(priority = 1)
	public void Blewithoutrouter_pairing() throws Exception {
		initAndriodDriver();
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);
		signuppage = new SignUpPage(driver);
		reportpage= new Reportpage(driver);
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		sZephyrinfopage = new Szephyr_info_Page(driver);
		analyticspage = new Analytics(driver);
		schedularpage=new Schedularpage(driver);
		
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
			readwrite.openPort();
			readwrite.write("reboot\r");
			Thread.sleep(3000);
		adddevicepage.pair(1);
		//sZephyr info page check
		sZephyrinfopage.deviceNameCheck(loadProp("USERNAMEINAPP"));
		sZephyrinfopage.brandNameCheck("Select Brand");
		sZephyrinfopage.modelnameCheck("Enter AC model name");
		sZephyrinfopage.capacityCheck("Enter capacity in ton");
		sZephyrinfopage.Roomsizecheck("Select room size");
		sZephyrinfopage.clickonRoomSize();
		Thread.sleep(1000);
		adddevicepage.clickNextButtonsZephyrInfo();
		adddevicepage.checkdevicedetailstoast();
		//device setings page check
		devicemenupage.checkLEDdefaultvalue();
		devicemenupage.infinitePoweronDefaultvalue();
		adddevicepage.clickSubmitButtonDeviceSetting();
		adddevicepage.checkdevicesettingstoast();
		
		//home page check
		devicemenupage.checkUsername_devicesettings("Home page");
		adddevicepage.bleConnectivityCheck();
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		
		//navigate into all page 
		homepage.clickShareicon();
		devicemenupage.checkUsername_devicesettings("Home page");
		homepage.backnavigation();
		analyticspage.navigateAnalyticsPage();
		devicemenupage.checkUsername_devicesettings("Home page");
		homepage.backnavigation();
		schedularpage.clickSchedulebtn();
		devicemenupage.checkUsername_devicesettings("Home page");
		schedularpage.clickandverifyOtherSchedulespage();
		homepage.backnavigation();
		homepage.clickandVerifyNotificationPage();
		homepage.backnavigation();
		
		//navigate to all components in device menu page
		//navigate to accounts info 
		homepage.clickMenuBarButton();
		homepage.clickAccountinfobutton();
		homepage.checkAccountsinfoDefaultValues();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
	
//		//navigate to szephyr info 
		homepage.clickMenuBarButton();
		sZephyrinfopage.clickSZephyrInfo_AfterPairing();
		sZephyrinfopage.checkDefaultValues_Szephyrinfopage_afterpairing();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
		
//		//navigate to add devie 
		homepage.clickMenuBarButton();
		adddevicepage.clickAddanotherDeviceButton();
		adddevicepage.newDevicePairingscreencheck();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
		
//		//navigate to device settings 
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.checkUsername_devicesettings("Device settings page");
		devicemenupage.checkLowVoltDefautvalue_devicesettings();
		homepage.backnavigation();
		devicemenupage.checkHighVoltDefautvalue_devicesettings();
		homepage.backnavigation();
		devicemenupage.checkDurationforOnDefautvalue_devicesettings();
		homepage.backnavigation();
		devicemenupage.checkEnergySavingDefautvalue_devicesettings();
		homepage.backnavigation();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickcancel();
		devicemenupage.ClickaddrouterButton();
		devicemenupage.clickcancel();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
//		devicemenupage.checkLEDdefaultvalue();
//		
//		
//		//navigate to remove device 
		homepage.clickMenuBarButton();
		devicemenupage.clickMenuBarRemoveDevice();
		devicemenupage.clickcancel();
		devicemenupage.checkUsername_devicesettings("Home page");
//		// navigate to logout 
		homepage.clickMenuBarButton();
		devicemenupage.clickLogoutButton();
		devicemenupage.clickcancel();
		devicemenupage.checkUsername_devicesettings("Home page");
		
		//navigate to report page 
		homepage.clickMenuBarButton();
		homepage.clickReportButton();
		reportpage.Reportanissuepagecontents_afterpairing();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
		
		
		//Connectivity test
		killAndReopenApp();
		devicemenupage.checkUsername_devicesettings("Home page");
		adddevicepage.bleConnectivityCheck();
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyONdesc();
		adddevicepage.bleConnectivityCheck();
		homepage.getCurrentvalue();
		homepage.getVoltvalue();
		homepage.getPowervalue();
		
		homepage.clickONOFFButton();
		Thread.sleep(2000);
		homepage.VerifyOFFdesc();
		
		
		//schedule and analytics check
		analyticspage.navigateAnalyticsPage();
		analyticspage.getenergydurationvalue();
		schedularpage.backToHomepage();
		schedularpage.clickSchedulebtn();
		schedularpage.createSchedules(3, 1, 1);//mention the time to start ,how many schedules need to keep,interval between next schedule
		schedularpage.backToHomepage();
		
		Thread.sleep(5*60*1000);//set thread values based on schedule duration kept .
		analyticspage.navigateAnalyticsPage();
		analyticspage.checkenrgyduration(1);
		schedularpage.backToHomepage();
		schedularpage.clickSchedulebtn();
		schedularpage.deleteschedule();
		schedularpage.backToHomepage();
		schedularpage.checkOffState();
		
		homepage.clickMenuBarButton();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		adddevicepage.checkdeviceresettoast();
		devicemenupage.AddDevicePagedisplayed();
		
		
		}
		catch (Exception e) {
//			readwrite.write("factory_reset\r");		
			readwrite.closePort();
			fail(e);
		}
		
	}
	//Before starting reset device via app.
	@Test(priority = 2)
	public void Blewithrouter_pairing() throws Exception {
		initAndriodDriver();
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);
		signuppage = new SignUpPage(driver);
		reportpage= new Reportpage(driver);
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		sZephyrinfopage = new Szephyr_info_Page(driver);
		analyticspage = new Analytics(driver);
		schedularpage=new Schedularpage(driver);
		
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
			readwrite.openPort();
			readwrite.write("reboot\r");
			Thread.sleep(3000);
			adddevicepage.pair(2);
			//sZephyr info page check
			sZephyrinfopage.deviceNameCheck(loadProp("USERNAMEINAPP"));
			sZephyrinfopage.brandNameCheck("Select Brand");
			sZephyrinfopage.modelnameCheck("Enter AC model name");
			sZephyrinfopage.capacityCheck("Enter capacity in ton");
			sZephyrinfopage.Roomsizecheck("Select room size");
			sZephyrinfopage.clickonRoomSize();
			Thread.sleep(1000);
			adddevicepage.clickNextButtonsZephyrInfo();
			adddevicepage.checkdevicedetailstoast();
			//device setings page check
			devicemenupage.checkLEDdefaultvalue();
			devicemenupage.infinitePoweronDefaultvalue();
			adddevicepage.clickSubmitButtonDeviceSetting();
			adddevicepage.checkdevicesettingstoast();
			
			//home page check
			devicemenupage.checkUsername_devicesettings("Home page");
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			//navigate into all page 
			homepage.clickShareicon();
			devicemenupage.checkUsername_devicesettings("Home page");
			homepage.backnavigation();
			analyticspage.navigateAnalyticsPage();
			devicemenupage.checkUsername_devicesettings("Home page");
			homepage.backnavigation();
			schedularpage.clickSchedulebtn();
			devicemenupage.checkUsername_devicesettings("Home page");
			schedularpage.clickandverifyOtherSchedulespage();
			homepage.backnavigation();
			homepage.clickandVerifyNotificationPage();
			homepage.backnavigation();
			
			//navigate to all components in device menu page
			//navigate to accounts info 
			homepage.clickMenuBarButton();
			homepage.clickAccountinfobutton();
			homepage.checkAccountsinfoDefaultValues();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to szephyr info 
			homepage.clickMenuBarButton();
			sZephyrinfopage.clickSZephyrInfo_AfterPairing();
			sZephyrinfopage.checkDefaultValues_Szephyrinfopage_afterpairing();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to add devie 
			homepage.clickMenuBarButton();
			adddevicepage.clickAddanotherDeviceButton();
			adddevicepage.newDevicePairingscreencheck();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to device settings 
			homepage.clickMenuBarButton();
			devicemenupage.clickDeviceSettingsButton();
			devicemenupage.checkUsername_devicesettings("Device settings page");
			devicemenupage.checkLowVoltDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkHighVoltDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkDurationforOnDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkEnergySavingDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.clickResetDeviceButton();
			devicemenupage.clickcancel();
			devicemenupage.ClickaddrouterButton();
			devicemenupage.clickcancel();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
//		devicemenupage.checkLEDdefaultvalue();
//		
//		
//		//navigate to remove device 
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickcancel();
			devicemenupage.checkUsername_devicesettings("Home page");
//		// navigate to logout 
			homepage.clickMenuBarButton();
			devicemenupage.clickLogoutButton();
			devicemenupage.clickcancel();
			devicemenupage.checkUsername_devicesettings("Home page");
			
			//navigate to report page 
			homepage.clickMenuBarButton();
			homepage.clickReportButton();
			reportpage.Reportanissuepagecontents_afterpairing();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
			
			//Connectivity test
			killAndReopenApp();
			devicemenupage.checkUsername_devicesettings("Home page");
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			homepage.VerifyONdesc();
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			homepage.VerifyOFFdesc();
			
			
			//schedule and analytics check
			analyticspage.navigateAnalyticsPage();
			analyticspage.getenergydurationvalue();
			schedularpage.backToHomepage();
			schedularpage.clickSchedulebtn();
			schedularpage.createSchedules(3, 1, 1);//mention the time to start ,how many schedules need to keep,interval between next schedule
			schedularpage.backToHomepage();
			
			Thread.sleep(5*60*1000);//set thread values based on schedule duration kept .
			analyticspage.navigateAnalyticsPage();
			analyticspage.checkenrgyduration(1);
			schedularpage.backToHomepage();
			schedularpage.clickSchedulebtn();
			schedularpage.deleteschedule();
			schedularpage.backToHomepage();
			schedularpage.checkOffState();
			
			homepage.clickMenuBarButton();
			devicemenupage.clickDeviceSettingsButton();
			devicemenupage.clickResetDeviceButton();
			devicemenupage.clickResetConfirmationYesButton();
			adddevicepage.checkdeviceresettoast();
			devicemenupage.AddDevicePagedisplayed();
			
			
		}
		catch (Exception e) {
//			readwrite.write("factory_reset\r");		
			readwrite.closePort();
			fail(e);
		}
		
	}
	//Before starting reset device via app.
	@Test(priority = 3)
	public void Smartconfig_pairing() throws Exception {
		initAndriodDriver();
		adddevicepage= new AddDevicePage(driver);
		homepage = new HomePage(driver);
		accountinfopage= new AccountsInfoPage(driver);
		devicesettingpage= new DeviceMenuPage(driver);
		signuppage = new SignUpPage(driver);
		reportpage= new Reportpage(driver);
		loginpage = new SignInPage(driver);
		landingpage = new LandingPage(driver);
		otppage = new OtpPage(driver);
		devicemenupage= new DeviceMenuPage(driver);
		sZephyrinfopage = new Szephyr_info_Page(driver);
		analyticspage = new Analytics(driver);
		schedularpage=new Schedularpage(driver);
		
		
		logReadandWrite readwrite = logReadandWrite.getInstance(loadProp("COM"));
		try {
			readwrite.openPort();
			readwrite.write("reboot\r");
			Thread.sleep(3000);
			adddevicepage.pair(3);
			//sZephyr info page check
			sZephyrinfopage.deviceNameCheck(loadProp("USERNAMEINAPP"));
			sZephyrinfopage.brandNameCheck("Select Brand");
			sZephyrinfopage.modelnameCheck("Enter AC model name");
			sZephyrinfopage.capacityCheck("Enter capacity in ton");
			sZephyrinfopage.Roomsizecheck("Select room size");
			sZephyrinfopage.clickonRoomSize();
			Thread.sleep(1000);
			adddevicepage.clickNextButtonsZephyrInfo();
			adddevicepage.checkdevicedetailstoast();
			//device setings page check
			devicemenupage.checkLEDdefaultvalue();
			devicemenupage.infinitePoweronDefaultvalue();
			adddevicepage.clickSubmitButtonDeviceSetting();
			adddevicepage.checkdevicesettingstoast();
			
			//home page check
			devicemenupage.checkUsername_devicesettings("Home page");
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			//navigate into all page 
			homepage.clickShareicon();
			devicemenupage.checkUsername_devicesettings("Home page");
			homepage.backnavigation();
			analyticspage.navigateAnalyticsPage();
			devicemenupage.checkUsername_devicesettings("Home page");
			homepage.backnavigation();
			schedularpage.clickSchedulebtn();
			devicemenupage.checkUsername_devicesettings("Home page");
			schedularpage.clickandverifyOtherSchedulespage();
			homepage.backnavigation();
			homepage.clickandVerifyNotificationPage();
			homepage.backnavigation();
			
			//navigate to all components in device menu page
			//navigate to accounts info 
			homepage.clickMenuBarButton();
			homepage.clickAccountinfobutton();
			homepage.checkAccountsinfoDefaultValues();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to szephyr info 
			homepage.clickMenuBarButton();
			sZephyrinfopage.clickSZephyrInfo_AfterPairing();
			sZephyrinfopage.checkDefaultValues_Szephyrinfopage_afterpairing();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to add devie 
			homepage.clickMenuBarButton();
			adddevicepage.clickAddanotherDeviceButton();
			adddevicepage.newDevicePairingscreencheck();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
//		//navigate to device settings 
			homepage.clickMenuBarButton();
			devicemenupage.clickDeviceSettingsButton();
			devicemenupage.checkUsername_devicesettings("Device settings page");
			devicemenupage.checkLowVoltDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkHighVoltDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkDurationforOnDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.checkEnergySavingDefautvalue_devicesettings();
			homepage.backnavigation();
			devicemenupage.clickResetDeviceButton();
			devicemenupage.clickcancel();
			devicemenupage.ClickaddrouterButton();
			devicemenupage.clickcancel();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
//		devicemenupage.checkLEDdefaultvalue();
//		
//		
//		//navigate to remove device 
			homepage.clickMenuBarButton();
			devicemenupage.clickMenuBarRemoveDevice();
			devicemenupage.clickcancel();
			devicemenupage.checkUsername_devicesettings("Home page");
//		// navigate to logout 
			homepage.clickMenuBarButton();
			devicemenupage.clickLogoutButton();
			devicemenupage.clickcancel();
			devicemenupage.checkUsername_devicesettings("Home page");
			
			//navigate to report page 
			homepage.clickMenuBarButton();
			homepage.clickReportButton();
			reportpage.Reportanissuepagecontents_afterpairing();
			homepage.backnavigation();
			devicemenupage.checkUsername_devicesettings("Home page");
			
			
			//Connectivity test
			killAndReopenApp();
			devicemenupage.checkUsername_devicesettings("Home page");
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			homepage.VerifyONdesc();
			adddevicepage.bleConnectivityCheck();
			homepage.getCurrentvalue();
			homepage.getVoltvalue();
			homepage.getPowervalue();
			
			homepage.clickONOFFButton();
			Thread.sleep(2000);
			homepage.VerifyOFFdesc();
			
			
			//schedule and analytics check
			analyticspage.navigateAnalyticsPage();
			analyticspage.getenergydurationvalue();
			schedularpage.backToHomepage();
			schedularpage.clickSchedulebtn();
			schedularpage.createSchedules(3, 1, 1);//mention the time to start ,how many schedules need to keep,interval between next schedule
			schedularpage.backToHomepage();
			
			Thread.sleep(5*60*1000);//set thread values based on schedule duration kept .
			analyticspage.navigateAnalyticsPage();
			analyticspage.checkenrgyduration(1);
			schedularpage.backToHomepage();
			schedularpage.clickSchedulebtn();
			schedularpage.deleteschedule();
			schedularpage.backToHomepage();
			schedularpage.checkOffState();
			
			homepage.clickMenuBarButton();
			devicemenupage.clickDeviceSettingsButton();
			devicemenupage.clickResetDeviceButton();
			devicemenupage.clickResetConfirmationYesButton();
			adddevicepage.checkdeviceresettoast();
			devicemenupage.AddDevicePagedisplayed();
			
			
		}
		catch (Exception e) {
//			readwrite.write("factory_reset\r");		
			readwrite.closePort();
			fail(e);
		}
		
	}



}	

