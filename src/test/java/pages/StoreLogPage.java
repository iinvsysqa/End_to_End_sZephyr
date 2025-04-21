package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import wrappers.GenericWrappers;

public class StoreLogPage extends GenericWrappers{

	private AndroidDriver driver;
	 public StoreLogPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
		@FindBy(xpath = "//*[@resource-id='menu_icon_sharelog']")
		private WebElement shareLogbtn;
		@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"File Manager +\"]")
		private WebElement FTPicon;
		@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.alphainventor.filemanager:id/name\" and @text=\"Downloads\"]")
		private WebElement FTPDownloads;
		@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.alphainventor.filemanager:id/text\" and @text=\"Save\"]")
		private WebElement FTPsaveBtn;
		@FindBy(xpath = "//*[@resource-id='menu_bar']")
		private WebElement menuBarButton;
		
		public void storeLogToDownloads() {
			killAndReopenApp();
			
			clickbyXpath(menuBarButton, " Menu Bar ");
			clickbyXpath(shareLogbtn, "ShareLog Button");
			clickbyXpath(FTPicon, "Filemanager Button");
			clickbyXpath(FTPDownloads, "Filemanager downloads Button");
			clickbyXpath(FTPsaveBtn, "Filemanager save Button");
			
		}
		public void takeAppLog() throws FileNotFoundException, IOException {
			File f= new File(".//sZephyrLOG.txt");
			if (f.exists()) {
				f.delete();
				}
			Runtime.getRuntime().exec("adb shell rm /storage/emulated/0/Download/*.txt");// to delete all .txt files 
		    storeLogToDownloads();
		    
			String projectRoot = System.getProperty("user.dir");
		    Runtime.getRuntime().exec("adb pull /storage/emulated/0/Download/sZephyrLOG.txt "+projectRoot+"/sZephyrLOG.txt");
		    if (driver.queryAppState(packages) != ApplicationState.RUNNING_IN_FOREGROUND) {
				driver.activateApp(packages); 
			}
			}
		
		
}
