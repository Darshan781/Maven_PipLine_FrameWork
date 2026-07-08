package com.demoapps.testBase;

import java.io.ByteArrayInputStream;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.demoapps.BrowserManager.BrowserFactory;
import com.demoapps.FrameWorkConstants.PathConstants;
import com.demoapps.configuration.ConfigurationManager;
import com.demoappsframework.utilities.BrowserControls;
import com.demoappsframework.utilities.ElementControls;
import com.demoappsframework.utilities.LoggerUtility;
import com.demoappsframework.utilities.ReadConfigData;
import com.demoappsframework.utilities.ScreenShotUtility;
import com.demoappsframwork.PageLayers.LoginPage;
import com.demoappsframwork.PageLayers.RegisterPage;
import com.demoappsframwork.PageLayers.UserPage;
import com.demoappsframwork.PageLayers.WelcomePage;

import io.qameta.allure.Allure;

//@Listeners(com.demoapps.Listeners.ReportsListeners.class)
public class BaseTest  {
	
	protected WebDriver driver;
	protected RegisterPage registerPage;
	protected WelcomePage welcomePage;
	protected BrowserControls browserControls; 
	protected ElementControls elementControls; 
	protected ReadConfigData configFile;
	protected UserPage userPage;
	protected LoginPage loginPage;
	protected BrowserFactory browserFactory;
	
	private final static Logger log = LoggerUtility.getLogger(BaseTest.class);

	
	@Parameters({"browserName","headlessMode","privateMode"})	 
	@BeforeClass
		public WelcomePage browserSetup(@Optional("")  String browserName, @Optional("") String headlessMode, @Optional("") String privateMode)  {
		
		//boolean headlessValue = Boolean.parseBoolean(headlessMode);
		//boolean privateValue = Boolean.parseBoolean(privateMode);

		String browser = ConfigurationManager.getbrowserName(browserName);
		Boolean headless = ConfigurationManager.getheadlessMode(headlessMode);
		Boolean incognito = ConfigurationManager.getprivateMode(privateMode);
		
		driver = BrowserFactory.initBrowser(browser,headless,incognito);
		browserControls = new BrowserControls(driver);
		configFile = new ReadConfigData(PathConstants.propertyFilePath);
		browserControls.maxmizeBrowser();
		welcomePage = new WelcomePage(driver);
		browserControls.enterUrl(configFile.readValue("testUrl"));
		log.info("The launched Browser is\t"+browserName);
		Reporter.log("The launched Browser is \t"+browserName,true);
		log.info("The launched Browser is in headlessmode");
		Reporter.log("The launched Browser is in headlessmode \t"+headless,true);
		log.info("The launched browser is in incognitomode");
		Reporter.log("The launched Browser is in incognitomode \t"+incognito,true);
		ChainTestListener.log("The launched Browser is \t"+browserName);
		ChainTestListener.log("The launched Browser is in \t"+headless);
		ChainTestListener.log("The launched Browser is  in \t"+incognito);
		return new WelcomePage(driver);
		
}
	
	public WelcomePage logoutApplication() {
		return loginPage.logoutApplication();
	}
	
	public UserPage loginApplication(String email, String pwd) {
	return loginPage.doLogin(email, pwd);
	}
	
	@AfterMethod
		public void attachScreenShotChainTest(ITestResult result)  {
		ScreenShotUtility screenShot = new ScreenShotUtility();
		if(!result.isSuccess()) {
			Reporter.log("Capturing screenshot for failed test case"+result.getName(),true);
			byte[] image = ScreenShotUtility.getScreenShotBytes(driver);
			Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(image), ".png");
			ChainTestListener.log("Capturing screenshot for faile test case"+ result.getName());
			ChainTestListener.embed(ScreenShotUtility.getScreenShotBytes(driver), "image/png");
		}
}
	
	@AfterClass(enabled = true)
	public void closeBrowser() {
		if(driver!=  null)
		browserControls.terminateBrowser();
		log.info("The launched browser is closed");
		Reporter.log("The launched browser is closed",true);
		ChainTestListener.log("The launched browser is closed");
	}
}
	