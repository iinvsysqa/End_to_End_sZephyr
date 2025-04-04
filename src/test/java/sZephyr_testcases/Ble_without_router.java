package sZephyr_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

public class Ble_without_router extends MobileAppWrappers {

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
		testCaseName = "End to End functionality check of Ble without router pairing ";
		//check login username and Accounts info username are same or not 
		//check for language selection 
		//pair with device try to del account and check for popup and try to remove device and try to del acnt and check add device page .

		testDescription = "Ble_without_router";
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
		homepage.clickMenuBarButtonafterpairing();
		homepage.clickAccountinfobutton();
		homepage.checkAccountsinfoDefaultValues();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
	
//		//navigate to szephyr info 
		homepage.clickMenuBarButtonafterpairing();
		sZephyrinfopage.clickSZephyrInfo_AfterPairing();
		sZephyrinfopage.checkDefaultValues_Szephyrinfopage_afterpairing();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
		
//		//navigate to add devie 
		homepage.clickMenuBarButtonafterpairing();
		adddevicepage.clickAddanotherDeviceButton();
		adddevicepage.newDevicePairingscreencheck();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
		
//		//navigate to device settings 
		homepage.clickMenuBarButtonafterpairing();
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
		devicemenupage.ClickaddrouterButton(1);
//		devicemenupage.clickcancel();
		homepage.backnavigation();
		devicemenupage.checkUsername_devicesettings("Home page");
//		devicemenupage.checkLEDdefaultvalue();
//		
//		
//		//navigate to remove device 
		homepage.clickMenuBarButtonafterpairing();
		devicemenupage.clickMenuBarRemoveDevice();
		devicemenupage.clickcancel();
		devicemenupage.checkUsername_devicesettings("Home page");
//		// navigate to logout 
		homepage.clickMenuBarButtonafterpairing();
		devicemenupage.clickLogoutButton();
		devicemenupage.clickcancel();
		devicemenupage.checkUsername_devicesettings("Home page");
		
		//navigate to report page 
		homepage.clickMenuBarButtonafterpairing();
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
		
		homepage.clickMenuBarButtonafterpairing();
		devicemenupage.clickDeviceSettingsButton();
		devicemenupage.clickResetDeviceButton();
		devicemenupage.clickResetConfirmationYesButton();
		adddevicepage.checkdeviceresettoast();
		devicemenupage.AddDevicePagedisplayed();
		readwrite.closePort();
		
		}
		catch (Exception e) {
			readwrite.closePort();
			fail(e);
		}
		
	}


}	

