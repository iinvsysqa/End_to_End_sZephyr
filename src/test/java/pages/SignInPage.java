package pages;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import utils.PassSTComment;
import wrappers.GenericWrappers;

public class SignInPage extends GenericWrappers {

	private AndroidDriver driver;
	public String userName = loadProp("USERNAME");
	public String emaId = loadProp("EMAILID");
	public String wifiPassword = loadProp("WIFIPASSWORD");
	public String deviceDetailsUpdated = loadProp("deviceDetailsUpdated");
	public String devicesettingsupdatesuccess = loadProp("deviceSettingsUpdateSuccess");
	public String DeviceRemovedSuccessfully = loadProp("DeviceRemovedSuccessfully");
	public String YourDeviceResetSuccessfully = loadProp("YourDeviceResetSuccessfully");
	public String RouterAddedSuccessfully = loadProp("RouterAddedSuccessfully");

	// Locate all elements on the page
	@FindBy(xpath = "//*[@resource-id='SignIn_Email_or_UserName']")
	private WebElement userNameField;

	@FindBy(xpath = "//*[@resource-id='SignIn_SignInText']")
	private WebElement signInButton;
	
	@FindBy(xpath = "//android.widget.Toast[@text='User Not Found']")
	private WebElement userNotFoundToast;
	
	@FindBy(xpath = "//*[@resource-id='Launch_SignInText']")
	private WebElement LaunchSigninText;
	@FindBy(xpath = "//*[@resource-id='menu_text_support']")
	private WebElement HelpBtn;
	@FindBy(xpath = "//*[@resource-id='Help with more infoText']")
	private WebElement Helpwithmoreinfobtn;
	
	 @FindBy(xpath = "//*[@resource-id='Launch_SignUpLink']")
		private WebElement signUpLink;
	 @FindBy(xpath = "//*[@resource-id='SignIn_Email_or_UserName']")
	 private WebElement signinmailtextbox;

	 @FindBy(xpath = "//*[@resource-id='menu_icon_removeDevice']")
		private WebElement removeDevice;
	 
	 @FindBy(xpath = "//*[@resource-id='Add_Devices_ButtonText']")
		private WebElement addDeviceButton;
	 
		@FindBy(xpath = "//android.widget.TextView[@text=\"sZephyr device is offline\"]")
		private WebElement deviceofflinealertTitle;
		
		@FindBy(xpath = "//android.widget.TextView[@text=\"ALERT\"]")
		private WebElement buttonPressAlert;

		@FindBy(xpath = "//android.widget.TextView[@text=\"OK\"]")
		private WebElement alertok;
		
		@FindBy(xpath = "//android.widget.Toast[@text=\"Username and Email ID both are already exists\"]")
		private WebElement UseralreadyExistsToast;

		private WebElement userName(String username) {
			return driver.findElement(By.xpath("//android.widget.TextView[@text='"+username+"']"));
			
		}
	// Constructor to initialize the driver and instantiate elements using
	
	public SignInPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods to be used as part of loginpage.
	
	public SignInPage enterUserName(String email) {
		entervaluebyXpath(userNameField, " User Name " , email);
		return this;
	}

	
	public SignInPage clickSignInButton() {
		clickbyXpath(signInButton, " Sign In ");
		return this;
		
	}


	public SignInPage checkUserNameNotFoundToast(String content) {
		verifyTextContainsByXpath(userNotFoundToast, content, " The Toast ");
		return this;
		
	}
	public void verifyRemovedevice() {
		
	}
	
	SignUpPage signuppage;
	AccountsInfoPage accountinfopage;
	LandingPage landingpage;
	SignInPage loginpage;
	HomePage homepage;
	OtpPage otppage;
	DeviceMenuPage devicemenupage;
	AddDevicePage addDevicepage;
	 public void verifysignInPage() throws Exception {
		 signuppage= new SignUpPage(driver);
			loginpage = new SignInPage(driver);
			landingpage = new LandingPage(driver);
			homepage = new HomePage(driver);
			otppage = new OtpPage(driver);
			devicemenupage = new DeviceMenuPage(driver);
			accountinfopage=new AccountsInfoPage(driver);
			addDevicepage= new AddDevicePage(driver);
			
			// Backgrounds app for 10 seconds
			homepage.WifiSwitch(loadProp("WIFINAME"), loadProp("WIFIPASSWORD"));

			turnOnBT();
			/*
			 * if (isElementDisplayedCheck(blePermissionOkButton)) {
			 * clickbyXpath(blePermissionOkButton, "Allowing Ble permission pop-up");
			 * checkappinforeground(); }
			 */	
			
			try {
				Thread.sleep(5000);
				if(isElementDisplayedCheck(LaunchSigninText)) {
					clickbyXpath(LaunchSigninText, "Launch Signin");
					enterUserName(emaId);
					clickSignInButton();
					otppage.verifyOTPVerificationTitle("OTP Verification");
					otppage.enterOTPField1("1");
					otppage.enterOTPField2("2");
					otppage.enterOTPField3("3");
					otppage.enterOTPField4("4");
					otppage.submitButton();
					homepage.clickMenuBarButton();
					if (isElementDisplayedCheck(removeDevice)) {
						devicemenupage.clickMenuBarRemoveDevice();
						devicemenupage.clickRemoveDevicePopupYesButton();
						Thread.sleep(2000);//or5000
						if (isElementDisplayedCheck(deviceofflinealertTitle)) {
							String text = deviceofflinealertTitle.getText();
							System.out.println(text + "  Alert pop-up displayed");
							clickbyXpath(alertok, "Alert ok button");

						} else if (isElementDisplayedCheck(buttonPressAlert)) {
							String text = buttonPressAlert.getText();
							System.out.println(text + "  Alert pop-up displayed");
							clickbyXpath(alertok, "Alert ok button");
					}
						
						
					}
					homepage.clickMenuBarButton();
					homepage.clickAccountinfobutton();
					accountinfopage.deleteaccount_toregisterpage();					

					
					
				} else if (isElementDisplayedCheck(addDeviceButton)) {
					homepage.clickMenuBarButton();
					homepage.clickAccountinfobutton();
					accountinfopage.deleteaccount_toregisterpage();
					
				}else{
					homepage.clickMenuBarButtonafterpairing();
					devicemenupage.clickMenuBarRemoveDevice();
					devicemenupage.clickRemoveDevicePopupYesButton();
					Thread.sleep(2000);//or5000
					if (isElementDisplayedCheck(deviceofflinealertTitle)) {
						String text = deviceofflinealertTitle.getText();
						System.out.println(text + "  Alert pop-up displayed");
						clickbyXpath(alertok, "Alert ok button");

					} else if (isElementDisplayedCheck(buttonPressAlert)) {
						String text = buttonPressAlert.getText();
						System.out.println(text + "  Alert pop-up displayed");
						clickbyXpath(alertok, "Alert ok button");
				}
					
					homepage.clickMenuBarButton();
					homepage.clickAccountinfobutton();
					accountinfopage.deleteaccount_toregisterpage();
					
				}
				} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Account is not deleted before_unable to signup");
			}
		
	}
	 
	 public void scrollTohelpwithmoreinfo() {
		 scrollToText("Help with more info");
	}
	 public void clickHelpbutton() {
		 clickbyXpath(HelpBtn, "Help button");
	}
	 public void clickHelpwithmoreinfobtn() {
		 clickbyXpath(Helpwithmoreinfobtn, "help with more info button");
	 }
	}
