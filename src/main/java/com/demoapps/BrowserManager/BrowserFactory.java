package com.demoapps.BrowserManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.demoapps.FrameWorkConstants.ApplicationConstants;
import com.demoappsframework.FrameWorkExpections.ApplicationExceptions;
import com.demoappsframework.utilities.LoggerUtility;

public class BrowserFactory {
	
	private final static Logger log = LoggerUtility.getLogger(BrowserFactory.class);
	protected static ThreadLocal<WebDriver> threadDriver;
	
	public static WebDriver initBrowser(String browserName, Boolean headlessMode, Boolean incognito) {
		
		
		browserName = browserName.toLowerCase().trim();
		threadDriver = new ThreadLocal<WebDriver>();
		switch(browserName) {
		case "chrome" : threadDriver.set(new ChromeDriver(BrowserOptions.getchrChromeOptions(headlessMode, incognito)));
		break;
		
		case "firefox" : threadDriver.set(new FirefoxDriver(BrowserOptions.getFirefoxOptions(headlessMode, incognito)));
		break;
		
		case "edge" : threadDriver.set(new EdgeDriver(BrowserOptions.getEdgeOptions(headlessMode, incognito)));
		break;
		
		default : log.info(ApplicationConstants.initBrowserInvalidBrowserNameErroMsglog);
			      Reporter.log(ApplicationConstants.initBrowserNameErrorMsg,true);
		          Reporter.log(ApplicationConstants.initBrowserInvalidBrowserNameErroMsg,true);
		          throw new ApplicationExceptions(ApplicationConstants.initBrowserInvalidBrowserNameErroMsg);
		}
		return getDriver();
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
		
	}
}
